#!/bin/bash
set -eo pipefail

platform=$(uname)

function unskip_tests {
  cd $1
  if [ -f *.spec.js ]; then
    echo "Unskipping tests in $1"
    if [ "$platform" == "Darwin" ]; then
        sed -i '' 's/xtest/test/g' *.spec.js
    else
        sed -i 's/xtest/test/g' *.spec.js
    fi
  fi
  cd ..
}

if [ "$1" == "" ];
then
    for d in */ ; do
        unskip_tests $d
    done
else
    for exercise in "$@"
    do
        unskip_tests $exercise
    done
fi
