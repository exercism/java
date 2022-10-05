#!/bin/bash
set -eo pipefail

function npm_uninstall {
  cd $1
  # check if node_modules directory exists
  if [ -d "node_modules" ]; then
    echo "Removing node modules in $1"
    size=`du -h -d0 node_modules/ | awk '{ print $1 }'`
    rm -rf node_modules
    echo "  Removed $size"
  fi
  cd ..
}

if [ "$1" = "" ];
then
    for d in */ ; do
        npm_uninstall $d
    done
else
    for exercise in "$@"
    do
        npm_uninstall $exercise
    done
fi
