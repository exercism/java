#!/bin/bash

trap 'exit 1' ERR
bin/build-jq.sh

pr_files_json=`curl -s https://api.github.com/repos/exercism/java/pulls/${TRAVIS_PULL_REQUEST}/files`

echo "Pull request number: ${TRAVIS_PULL_REQUEST}"
echo "Changes in pr json: ${pr_files_json}"

# if jq fails to get the required data, then that means TRAVIS_PULL_REQUEST was not set (not run in travis-ci),
# or was false (not a pull request). In that case, we should fall back with testing every exercise

modded_files=`echo $pr_files_json | bin/jq -r '.[].filename'` || bin/journey-test.sh

for file in $modded_files
  do if [[ $file == exercises* ]] || [[ $file == config.json ]]
    then
    for file2 in $modded_files
      do if [[ $file2 == exercises* ]] && [[ $file2 != exercises/settings.gradle ]] && [[ $file2 != exercises/build.gradle ]]
        then modded_exercise=${file2#exercises/}
        modded_exercise=${modded_exercise%%/*}
        if [[ $last_modded_exercise != $modded_exercise ]]
          then modded_exercises=$modded_exercises$modded_exercise$'\n'
        fi
        last_modded_exercise=$modded_exercise
      fi
    done
    bin/journey-test.sh $modded_exercises
    break
  fi
done
