#!/bin/bash

contains_setup_file() {
  local files=$1
  for file in $files; do
    if [[ $file == *.gradle || $file == *.sh || $file == config.json ]]; then
      return 0
    fi
  done
  return 1
}

contains_exercise() {
  local files=$1
  for file in $files; do
    if [[ $file == exercises* ]]; then
      return 0
    fi
  done
  return 1
}

run_journey_test_with_modified_exercises() {
  local modded_files=$1
  local last_modded_exercise=""
  local modded_exercises=""

  for file in $modded_files; do
    if [[ $file == exercises* ]] && [[ $file != exercises/settings.gradle ]] && [[ $file != exercises/build.gradle ]]; then
      local modded_exercise=${file#exercises/}
      modded_exercise=${modded_exercise%%/*}
      if [[ $last_modded_exercise != $modded_exercise ]]; then
        modded_exercises=$modded_exercises$modded_exercise$'\n'
      fi
      last_modded_exercise=$modded_exercise
    fi
  done

  echo "Running journey test with modified exercise(s): ${modded_exercises}"
  bin/journey-test.sh $modded_exercises
}

run_journey_test_with_all_exercises() {
  echo "Running journey test with all exercises"
  bin/journey-test.sh
}

main() {
  bin/build-jq.sh

  local pr_files_json=`curl -s https://api.github.com/repos/exercism/java/pulls/${TRAVIS_PULL_REQUEST}/files`

  echo "Pull request number: ${TRAVIS_PULL_REQUEST}"
  echo "Changes in pr json: ${pr_files_json}"

  # if jq fails to get the required data, then that means TRAVIS_PULL_REQUEST was not set (not run in travis-ci),
  # or was false (not a pull request), or the api limit was reached, or some other error occurred.
  # In that case, we should fall back with testing every exercise
  local pr_files_json_type=`echo $pr_files_json | bin/jq -r 'type'`
  if [[ $pr_files_json_type != "array" ]]; then
    echo "Didn't get pr changes from travis"
    run_journey_test_with_all_exercises
    return
  fi

  local modded_files=`echo $pr_files_json | bin/jq -r '.[].filename'`

  # If the changed files contain a .sh file or .gradle file or config.json then we should run all the exercises
  if contains_setup_file "${modded_files}"; then
    echo "Pr changes contain setup file(s): ${modded_files}"
    run_journey_test_with_all_exercises
    return
  fi

  if contains_exercise "${modded_files}"; then
    echo "Pr changes contain modified exercise file(s)"
    run_journey_test_with_modified_exercises "${modded_files}"
  fi
}

trap 'exit 1' ERR
main
