#!/bin/bash
set -eo pipefail

function npm_install {
  echo "Installing npm packages in $1"
  cd $1
  npm install
  cd ..
}

if [ "$1" == "" ];
then
    for d in */ ; do
        npm_install $d
    done
else
    for exercise in "$@"
    do
        npm_install $exercise
    done
fi
