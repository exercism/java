#!/bin/bash
set -eo pipefail

platform=$(uname)

function unskip_tests {
  echo "Unskipping tests in $1"
  cd $1
  if [ "$platform" == "Darwin" ]; then
    sed -i '' 's/xtest/test/g' *.test.js
  else
    sed -i 's/xtest/test/g' *.test.js
  fi
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
