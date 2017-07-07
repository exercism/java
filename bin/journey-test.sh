#!/usr/bin/env bash

# This script is shared between the Java and Kotlin tracks.  If you make an update to this script on
# one track, please create a companion PR to merge it in to the other.  Thank you!
TRACK=java
TRACK_REPO="$TRACK"
TRACK_SRC_EXT="java"

on_exit() {
  echo ">>> on_exit()"
  if [[ "$xapi_pid" != "" ]] ; then
    kill $xapi_pid
    echo "stopped x-api (pid=${xapi_pid})"
  fi
  cd $EXECPATH
  echo "<<< on_exit()"
}

assert_installed() {
  local binary=$1
  echo ">>> assert_installed(binary=\"${binary}\")"

  if [[ "`which $binary`" == "" ]]; then
    echo "${binary} not found; it is required to perform this test."
    echo -e "Have you completed the setup instructions at https://github.com/exercism/${TRACK_REPO} ?\n"
    echo "PATH=${PATH}"
    echo "aborting."
    exit 1
  fi
  echo "<<< assert_installed()"
}

assert_ruby_installed() {
  local ruby_app_home="$1"
  echo ">>> assert_ruby_installed(ruby_app_home=\"${ruby_app_home}\")"

  pushd "${ruby_app_home}"
  local current_ruby_ver=`ruby --version | egrep --only-matching "[0-9]+\.[0-9]+\.[0-9]+"`
  local expected_ruby_ver=`cat Gemfile | awk -F\' '/ruby /{print $2}'`
  popd
  if [[ "${expected_ruby_ver}" != "" && "${current_ruby_ver}" != "${expected_ruby_ver}" ]]; then
    echo "${ruby_app_home} requires Ruby ${expected_ruby_ver}; current Ruby version is ${current_ruby_ver}."
    echo -e "Ruby used: `which ruby`.\n"
    echo -e "Have you completed the setup instructions at https://github.com/exercism/${TRACK_REPO} ?\n"
    echo "PATH=${PATH}"
    echo "aborting."
    exit 1
  fi
  echo "<<< assert_ruby_installed()"
}

clean() {
  local build_dir="$1"
  echo ">>> clean(build_dir=\"${build_dir}\")"

  # empty, absolute path, or parent reference are considered dangerous to rm -rf against.
  if [[ "${build_dir}" == "" || ${build_dir} =~ ^/ || ${build_dir} =~ \.\. ]] ; then
    echo "Value for build_dir looks dangerous.  Aborting."
    exit 1
  fi

  local build_path=$( pwd )/${build_dir}
  if [[ -d "${build_path}" ]] ; then
    echo "Cleaning journey script build output directory (${build_path})."
    rm -rf "${build_path}"
  fi
  cd exercises
  "$EXECPATH"/gradlew clean
  cd ..
  echo "<<< clean()"
}

get_operating_system() {
  case $(uname) in
      (Darwin*)
          echo "mac";;
      (Linux*)
          echo "linux";;
      (Windows*)
          echo "windows";;
      (MINGW*)
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

download_exercism_cli() {
  local os="$1"
  local arch="$2"
  local exercism_home="$3"
  echo ">>> download_exercism_cli(os=\"${os}\", arch=\"${arch}\", exercism_home=\"${exercism_home}\")"

  local CLI_RELEASES=https://github.com/exercism/cli/releases

  local latest=${CLI_RELEASES}/latest
  # "curl..." :: HTTP 302 headers, including "Location" -- URL to redirect to.
  # "awk..." :: pluck last path segment from "Location" (i.e. the version number)
  local version="$(curl --head --silent ${latest} | awk -v FS=/ '/Location:/{print $NF}' | tr -d '\r')"

  local download_url_suffix
  local unzip_command
  local unzip_from_file_option
  if [[ ${os} == "windows" ]] ; then
    download_url_suffix="zip"
    unzip_command="unzip -d"
    unzip_from_file_option=""
  else
    download_url_suffix="tgz"
    unzip_command="tar xz -C"
    unzip_from_file_option="-f"
  fi
  local download_url=${CLI_RELEASES}/download/${version}/exercism-${os}-${arch}.${download_url_suffix}

  mkdir -p ${exercism_home}
  local temp=`mktemp`
  curl -s --location ${download_url} > ${temp}
  ${unzip_command} ${exercism_home} ${unzip_from_file_option} ${temp}
  echo "<<< download_exercism_cli()"
}

git_clone() {
  local repo_name="$1"
  local dest_path="$2"
  echo ">>> git_clone(repo_name=\"${repo_name}\", dest_path=\"${dest_path}\")"

  git clone https://github.com/exercism/${repo_name} ${dest_path}

  echo "<<< git_clone()"
}

make_local_trackler() {
  local trackler="$1"
  local xapi_home="$2"
  echo ">>> make_local_trackler(trackler=\"${trackler}\", xapi_home=\"${xapi_home}\")"

  local track_root=$( pwd )
  pushd ${trackler}

  # Get the version of Trackler x-api is currently using
  local version=$( grep -m 1 'trackler' ${xapi_home}/Gemfile.lock | sed 's/.*(//' | sed 's/)//' )

  git checkout v${version}
  git submodule init -- problem-specifications
  git submodule update

  # Bake in local copy of this track; this is what we are testing.
  rmdir tracks/${TRACK}
  mkdir -p tracks/${TRACK}/exercises
  cp ${track_root}/config.json tracks/${TRACK}
  cp -r ${track_root}/exercises tracks/${TRACK}

  gem install bundler
  bundle install -j4
  gem build trackler.gemspec

  # Make *this* the gem that x-api uses when we build x-api.
  gem install --local trackler-*.gem

  popd > /dev/null
  echo "<<< make_local_trackler()"
}

start_x_api() {
  local xapi_home="$1"
  echo ">>> start_x_api(xapi_home=\"${xapi_home}\")"

  pushd $xapi_home

  gem install bundler
  bundle install -j4
  RACK_ENV=development rackup &
  xapi_pid=$!
  sleep 5

  echo "x-api is running (pid=${xapi_pid})."

  popd > /dev/null
  echo "<<< start_x_api()"
}

configure_exercism_cli() {
  local exercism_home="$1"
  local exercism_configfile="$2"
  local xapi_port=$3
  echo ">>> configure_exercism_cli(exercism_home=\"${exercism_home}\", exercism_configfile=\"${exercism_configfile}\", xapi_port=${xapi_port})"
  local exercism="./exercism --config ${exercism_configfile}"

  mkdir -p "${exercism_home}"
  pushd "${exercism_home}"
  $exercism configure --dir="${exercism_home}"
  $exercism configure --api http://localhost:${xapi_port}
  $exercism debug
  popd

  echo "<<< configure_exercism_cli()"
}

solve_all_exercises() {
  local exercism_exercises_dir="$1"
  local exercism_configfile="$2"
  echo ">>> solve_all_exercises(exercism_exercises_dir=\"${exercism_exercises_dir}\", exercism_configfile=\"${exercism_configfile}\")"

  local track_root=$( pwd )
  local exercism_cli="./exercism --config ${exercism_configfile}"
  local exercises=`cat config.json | jq '.exercises[].slug + " "' --join-output`
  local total_exercises=`cat config.json | jq '.exercises | length'`
  local current_exercise_number=1
  local tempfile="${TMPDIR:-/tmp}/journey-test.sh-unignore_all_tests.txt"

  pushd ${exercism_exercises_dir}
  for exercise in $exercises; do
    echo -e "\n\n"
    echo "=================================================="
    echo "${current_exercise_number} of ${total_exercises} -- ${exercise}"
    echo "=================================================="

    ${exercism_cli} fetch ${TRACK} $exercise
    cp -R -H ${track_root}/exercises/${exercise}/src/example/${TRACK}/* ${exercism_exercises_dir}/${TRACK}/${exercise}/src/main/${TRACK}/

    pushd ${exercism_exercises_dir}/${TRACK}/${exercise}
    # Check that tests compile before we strip @Ignore annotations
    "$EXECPATH"/gradlew compileTestJava --configure-on-demand --parallel
    # Ensure we run all the tests (as delivered, all but the first is @Ignore'd)
    for testfile in `find . -name "*Test.${TRACK_SRC_EXT}"`; do
      # Strip @Ignore annotations to ensure we run the tests (as delivered, all but the first is @Ignore'd).
      # Note that unit-test.sh also strips @Ignore annotations via the Gradle task copyTestsFilteringIgnores.
      # The stripping implementations here and in copyTestsFilteringIgnores should be kept consistent.
      sed 's/@Ignore\(\(.*\)\)\{0,1\}//' ${testfile} > "${tempfile}" && mv "${tempfile}" "${testfile}"
    done
    "$EXECPATH"/gradlew test --configure-on-demand --parallel &
    popd

    current_exercise_number=$((current_exercise_number + 1))
  done
  popd
}

main() {
  # all functions assume current working directory is repository root.
  cd "${SCRIPTPATH}/.."

  local track_root=$( pwd )
  local build_dir="build"
  local build_path="${track_root}/${build_dir}"

  local xapi_home="${build_path}/x-api"
  local trackler_home="${build_path}/trackler"
  local exercism_home="${build_path}/exercism"

  local exercism_configfile=".journey-test.exercism.json"
  local xapi_port=9292

  # fail fast if required binaries are not installed.
  assert_installed "jq"

  clean "${build_dir}"

  # Download everything we need in parallel
  git_clone "x-api" "${xapi_home}" &
  git_clone "trackler" "${trackler_home}" &
  download_exercism_cli $(get_operating_system) $(get_cpu_architecture) "${exercism_home}" &
  wait

  # Check and install the ruby stuff we need in parallel
  assert_ruby_installed "${trackler_home}" &
  assert_ruby_installed "${xapi_home}" &
  wait

  # Make a local version of trackler
  make_local_trackler "${trackler_home}" "${xapi_home}"

  # Start-up a local instance of x-api so we can fetch the exercises through it.
  start_x_api "${xapi_home}"

  # Create a CLI install and config just for this build; this script does not use your CLI install.
  configure_exercism_cli "${exercism_home}" "${exercism_configfile}" "${xapi_port}"

  solve_all_exercises "${exercism_home}" "${exercism_configfile}"
}

##########################################################################
# Execution begins here...

# If any command fails, fail the script.
set -ex
SCRIPTPATH=$( pushd `dirname $0` > /dev/null && pwd && popd > /dev/null )
EXECPATH=$( pwd )
# Make output easier to read in CI
TERM=dumb

xapi_pid=""
trap on_exit EXIT
main

