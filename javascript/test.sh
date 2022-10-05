#!/bin/bash
set -eo pipefail

function run_tests {
  echo "Running tests in $1"
  cd $1
  npm run test
  cd ..
}

if [ "$1" == "" ];
then
    for d in */ ; do
        run_tests $d
    done
else
    for exercise in "$@"
    do
        run_tests $exercise
    done
fi
