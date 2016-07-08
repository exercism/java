#!/bin/bash

if [ "$0" != "./bin/run-journey-test-locally.sh" ]; then
  echo "This script must be run from the root of the xjava checkout."
  echo "Please change directory there and try again."
  echo -e "\n  $ ./bin/run-journey-test-locally.sh"
  exit 1
fi

function teardown() {
  if [ "$XAPI_PID" != "" ] ; then
     kill $XAPI_PID
  fi
}

trap teardown EXIT

set -e

REPO_ROOT=$PWD
BUILD_DIR=$REPO_ROOT/build
export GOPATH=$BUILD_DIR/go
XAPI_HOME=$BUILD_DIR/x-api
EXERCISM_HOME=$BUILD_DIR/exercism
SET_RUBY_VER_CMD="rbenv local 2.2.1"

if [ -d "$BUILD_DIR" ] ; then
  rm -rf "$BUILD_DIR"
fi

mkdir -p $XAPI_HOME
cd $XAPI_HOME
git clone https://github.com/exercism/x-api .
git submodule init -- metadata
git submodule update
( cd tracks && rmdir java && ln -s $REPO_ROOT java && cd java/exercises && gradle clean )


$SET_RUBY_VER_CMD
gem install bundler
bundle install

RACK_ENV=development rackup&
export XAPI_PID=$!

sleep 5

export PATH=$PATH:$GOPATH/bin
go get -u github.com/exercism/cli/exercism
EXERCISM="exercism --config $EXERCISM_HOME/.exercism.json"


mkdir -p $EXERCISM_HOME
cd $EXERCISM_HOME
$EXERCISM configure --dir=$EXERCISM_HOME
$EXERCISM configure --api http://localhost:9292

$EXERCISM debug

cd $REPO_ROOT
EXERCISES=`cat config.json | jq '.problems []' --raw-output`
TOTAL_EXERCISES=`cat config.json | jq '.problems | length'`
CURRENT_EXERCISE_NUMBER=1

for EXERCISE in $EXERCISES; do
  echo ''
  echo '****' Testing $EXERCISE '('$CURRENT_EXERCISE_NUMBER / $TOTAL_EXERCISES') ****'
  echo ''
  $EXERCISM fetch java $EXERCISE
  cp -R -H $REPO_ROOT/exercises/$EXERCISE/src/example/java/* $EXERCISM_HOME/java/$EXERCISE/src/main/java/
  cd $EXERCISM_HOME/java/$EXERCISE/
  gradle test

  CURRENT_EXERCISE_NUMBER=$((CURRENT_EXERCISE_NUMBER + 1))
done
