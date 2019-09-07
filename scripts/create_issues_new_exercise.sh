#!/bin/bash

print_usage() {
    echo ">>>>> Usage: scripts/create_issues_new_exercise.sh -t path/to/track -s path/to/problem/specifications"
}

command -v jq >/dev/null 2>&1 || {
    echo >&2 ">>>>> This script requires jq but it's not installed. Aborting."
    exit 1
}

num_args=$#

if [[ $num_args = 0 ]]; then
    print_usage
    exit 0
fi

path_to_track=
path_to_problem_specifications=

while getopts ":t:s:" option; do
    case "$option" in
        "t")
            path_to_track="$OPTARG"
            ;;
        "s")
            path_to_problem_specifications="$OPTARG"
            ;;
        *)
            echo ">>>>> Unrecognized option. Aborting."
            print_usage
            exit 1
            ;;
    esac
done

if [[ -z "$path_to_track" ]]; then
    echo ">>>>> Path to track missing."
    print_usage
    exit 1
fi

if [[ -z "$path_to_problem_specifications" ]]; then
    echo ">>>>> Path to problem specifications missing."
    print_usage
    exit 1
fi

config_file_path="$path_to_track/config.json"

if ! [[ -f "$config_file_path" ]]; then
    echo ">>>>> Config file not found at ${config_file_path}."
    exit 1
fi

problem_spec_exercises=
exercise_name=
track_foregone_exercises=$(jq '.foregone[]' "$config_file_path" | tr -d "\"")
track_deprecated_exercises=$(jq '.exercises[] | select(has("deprecated")) | .slug' "$config_file_path" | tr -d "\"")

for path_to_exercise in ${path_to_problem_specifications}/exercises/*; do
  if [[ -d "$path_to_exercise" ]]; then
    if [[ -f "$path_to_exercise"/.deprecated ]]; then
      continue
    fi
    exercise_name=$(echo "$path_to_exercise" | sed "s/.*\///")
    problem_spec_exercises="$problem_spec_exercises $exercise_name"
  fi
done

track_exercise_slugs=$(jq '.exercises[] | select(has("deprecated") | not) | .slug' "$config_file_path" | tr -d "\"" | sort)

COUNT=0
for exercise in $problem_spec_exercises; do
  if echo "$track_exercise_slugs" | grep -q "$exercise" ; then
    continue
  elif echo "$track_deprecated_exercises" | grep -q "$exercise"; then
    continue
  elif echo "$track_foregone_exercises" | grep -q "$exercise"; then
    continue
  fi
  echo "Exercise $exercise is not implemented in the Java track."
  (( COUNT+=1 ))
done

echo "Total: $COUNT exercises"

exit 0
