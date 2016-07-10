#!/bin/bash
SCRIPTPATH=$( pushd `dirname $0` > /dev/null && pwd && popd > /dev/null )
EXECPATH=$PWD
XAPI_PID=""

function on_exit() {
  echo ">>> on_exit()"
  if [ "$XAPI_PID" != "" ] ; then
    kill $XAPI_PID
    echo "Stopped X-API (pid=${XAPI_PID})"
  fi
  cd $EXECPATH
  echo "<<< on_exit()"
}

assert_gradle_installed() {
  echo ">>> assert_gradle_installed()"
  which gradle >/dev/null
  if [ $? != 0 ]; then
    echo "Gradle not found.  This the Java build tool and is required."
    echo -e "Have you completed the setup instructions at https://github.com/exercism/xjava ?\n"
    echo "PATH=${PATH}"
    echo "aborting."
    exit 1
  fi
  echo "<<< assert_gradle_installed()"
}

assert_jq_installed() {
  echo ">>> assert_jq_installed()"
  which jq >/dev/null
  if [ $? != 0 ]; then
    echo "jq not found.  This utility is used to parse the config.json file and is required."
    echo -e "Have you completed the setup instructions at https://github.com/exercism/xjava ?\n"
    echo "PATH=${PATH}"
    echo "aborting."
    exit 1
  fi
  echo "<<< assert_jq_installed()"
}

assert_required_ruby_installed() {
  echo ">>> assert_required_ruby_installed(\"$1\")"
  local RACKAPP_HOME="$1"

  pushd "${RACKAPP_HOME}" >/dev/null
  local CURRENT_RUBY_VER=`ruby --version | egrep --only-matching "[0-9]+\.[0-9]+\.[0-9]+"`
  local EXPECTED_RUBY_VER=`cat Gemfile | awk -F\' '/ruby /{print $2}'`
  popd >/dev/null
  if [ "$CURRENT_RUBY_VER" != "$EXPECTED_RUBY_VER" ]; then
    echo "${RACKAPP_HOME} requires Ruby ${EXPECTED_RUBY_VER}; current Ruby version is ${CURRENT_RUBY_VER}."
    echo -e "Ruby used: `which ruby`.\n"
    echo -e "Have you completed the setup instructions at https://github.com/exercism/xjava ?\n"
    echo "PATH=${PATH}"
    echo "aborting."
    exit 1
  fi
  echo "<<< assert_required_ruby_installed()"
}

clean_build() {
  echo ">>> clean_build(\"$1\", \"$2\")"
  local REPO_ROOT="$1"
  local BUILD_DIR="$2"

  if [ -d "$BUILD_DIR" ] ; then
    echo "Cleaning journey script build (${BUILD_DIR})."
    rm -rf "$BUILD_DIR"
  fi
  pushd ${REPO_ROOT}/exercises > /dev/null
  gradle clean
  popd > /dev/null
  echo "<<< clean_build()"
}

get_operating_system() {
  case $(uname) in
      (Darwin*)
          echo "mac";;
      (Linux*)
          echo "linux";;
      (Windows*)
          echo "windows";;
      (*)
          echo "linux";;
  esac
}

get_cpu_architecture() {
  case $(uname -m) in
      (*64*)
          echo 64bit;;
      (*686*)
          echo 32bit;;
      (*386*)
          echo 32bit;;
      (*)
          echo 64bit;;
  esac
}

fetch_exercism_cli() {
  echo ">>> fetch_exercism_cli(\"$1\", \"$2\", \"$3\")"
  local OS="$1"
  local ARCH="$2"
  local EXERCISM_HOME="$3"

  local LATEST=https://github.com/exercism/cli/releases/latest
  # "curl..." :: HTTP 302 headers, including "Location" -- URL to redirect to.
  # "awk..." :: pluck last path segment from "Location" (i.e. the version number)
  local VERSION="$(curl --head --silent $LATEST | awk -v FS=/ '/Location:/{print $NF}' | tr -d '\r')"
  local CLI_URL=https://github.com/exercism/cli/releases/download/${VERSION}/exercism-${OS}-${ARCH}.tgz

  mkdir -p ${EXERCISM_HOME}
  curl -s --location ${CLI_URL} | tar xz -C ${EXERCISM_HOME}
  echo "<<< fetch_exercism_cli()"
}

fetch_x_api() {
  echo ">>> fetch_x_api(\"$1\")"
  local XAPI_HOME="$1"

  git clone https://github.com/exercism/x-api ${XAPI_HOME}
  pushd ${XAPI_HOME} >/dev/null
  git submodule init -- metadata
  git submodule update
  rmdir tracks/java
  ln -s $REPO_ROOT tracks/java
  popd > /dev/null
  echo "<<< fetch_x_api()"
}

start_x_api() {
  echo ">>> start_x_api(\"$1\")"
  local XAPI_HOME="$1"

  pushd $XAPI_HOME >/dev/null

  SET_RUBY_VER_CMD="rbenv local 2.2.1"
  gem install bundler
  bundle install

  RACK_ENV=development rackup &
  XAPI_PID=$!
  sleep 5

  echo "X-API is running (pid=${XAPI_PID})."

  popd > /dev/null
  echo "<<< start_x_api()"
}

configure_exercism_cli() {
  echo ">>> configure_exercism_cli(\"$1\", \"$2\", $3)"
  local EXERCISM_HOME="$1"
  local EXERCISM_CONFIGFILE="$2"
  local XAPI_PORT=$3
  local EXERCISM="./exercism --config ${EXERCISM_CONFIGFILE}"

  mkdir -p "${EXERCISM_HOME}"
  pushd "${EXERCISM_HOME}" >/dev/null
  $EXERCISM configure --dir="${EXERCISM_HOME}"
  $EXERCISM configure --api http://localhost:${XAPI_PORT}
  $EXERCISM debug
  popd >/dev/null

  echo "<<< configure_exercism_cli()"
}

solve_all_exercises() {
  echo ">>> solve_all_exercises(\"$1\", \"$2\")"

  local EXERCISM_HOME="$1"
  local EXERCISM_CONFIGFILE="$2"

  local EXERCISM="./exercism --config ${EXERCISM_CONFIGFILE}"
  local EXERCISES=`cat config.json | jq '.problems []' --raw-output`
  local TOTAL_EXERCISES=`cat config.json | jq '.problems | length'`
  local CURRENT_EXERCISE_NUMBER=1

  pushd ${EXERCISM_HOME} >/dev/null
  for EXERCISE in $EXERCISES; do
    echo ''
    echo '****' Testing $EXERCISE '('$CURRENT_EXERCISE_NUMBER / $TOTAL_EXERCISES') ****'
    echo ''
    $EXERCISM fetch java $EXERCISE
    cp -R -H $REPO_ROOT/exercises/$EXERCISE/src/example/java/* $EXERCISM_HOME/java/$EXERCISE/src/main/java/
    pushd $EXERCISM_HOME/java/$EXERCISE/ >/dev/null
    gradle test
    popd >/dev/null

    CURRENT_EXERCISE_NUMBER=$((CURRENT_EXERCISE_NUMBER + 1))
  done
  popd >/dev/null
}

main() {
  # allow all functions to assume current working directory is repository root.
  cd "${SCRIPTPATH}/.."

  local REPO_ROOT="${PWD}"
  local BUILD_DIR="${REPO_ROOT}/build"
  local XAPI_HOME="${BUILD_DIR}/x-api"
  local EXERCISM_HOME="${BUILD_DIR}/exercism"
  local EXERCISM_CONFIGFILE=".journey-test.exercism.json"
  local XAPI_PORT=9292

  assert_gradle_installed
  assert_jq_installed
  clean_build "${REPO_ROOT}" "${BUILD_DIR}"
  fetch_exercism_cli $(get_operating_system) $(get_cpu_architecture) "${EXERCISM_HOME}"
  fetch_x_api "${XAPI_HOME}"
  assert_required_ruby_installed "${XAPI_HOME}"
  start_x_api "${XAPI_HOME}"
  configure_exercism_cli "${EXERCISM_HOME}" "${EXERCISM_CONFIGFILE}" "${XAPI_PORT}"
  solve_all_exercises "${EXERCISM_HOME}" "${EXERCISM_CONFIGFILE}"
}

##########################################################################
# Execution begins here...

set -e
trap on_exit EXIT
main

