#!/bin/bash

bin/build-jq.sh

pr_files_json=`curl -s https://api.github.com/repos/exercism/java/pulls/${TRAVIS_PULL_REQUEST}/files`
modded_files=`echo $pr_files_json | bin/jq -r '.[].filename'`

for file in $modded_files
  do if [[ $file == exercises* ]] || [[ $file == config.json ]]
    then
    for file2 in $modded_files
      do if [[ $file2 == exercises* ]]
        then modded_exercise=${file2#exercises/}
        modded_exercise=${modded_exercise%%/*}
      fi
    done
    bin/journey-test.sh $modded_exercise
    break
  fi
done
