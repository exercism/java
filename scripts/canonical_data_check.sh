#!/usr/bin/env bash

print_usage() {
    echo "Usage: ./canonical_data_check.sh -t path/to/track -s path/to/problem/specifications"
}

# Execution begins

command -v jq >/dev/null 2>&1 || {
    echo >&2 "This script requires jq but it's not installed. Aborting."
    exit 1
}

num_args=$#

if [ $num_args -eq 0 ]
then
    print_usage
    exit 0
fi

path_to_track=
path_to_problem_specifications=

while getopts ":t:s:" option
do
    case "$option" in
        "t")
            path_to_track="$OPTARG"
            ;;
        "s")
            path_to_problem_specifications="$OPTARG"
            ;;
        *)
            echo "Unrecognized option. Aborting."
            print_usage
            exit 1
            ;;
    esac
done

if [ -z "$path_to_track" ]
then
    echo "Path to track missing."
    print_usage
    exit 1
fi

if [ -z "$path_to_problem_specifications" ]
then
    echo "Path to problem specifications missing."
    print_usage
    exit 1
fi

config_file_path="$path_to_track/config.json"

if ! [ -f "$config_file_path" ]
then
    echo "Config file not found at $config_file_path."
    exit 1
fi

track_exercise_slugs=$(jq '.exercises[] | select(has("deprecated") | not) | .slug' $config_file_path | tr -d "\"")
update_needed_count=0

for slug in $track_exercise_slugs
do
    canonical_data_folder_path="$path_to_problem_specifications/exercises/$slug"

    if ! [ -d "$canonical_data_folder_path" ]
    then
        echo "Canonical data folder $canonical_data_folder_path not found. Aborting."
        exit 1
    fi

    canonical_data_file_path="$canonical_data_folder_path/canonical-data.json"

    if ! [ -f "$canonical_data_file_path" ]
    then
        # echo "$slug: no canonical data found."
        continue
    fi

    canonical_data_version=$(jq '.version' $canonical_data_file_path | tr -d "\"")

    track_exercise_version_file_path="$path_to_track/exercises/$slug/.meta/version"

    if ! [ -f "$track_exercise_version_file_path" ]
    then
        echo "$slug: needs update or version file (v$canonical_data_version)."
        update_needed_count=$((update_needed_count + 1))
        continue
    fi

    track_data_version=$(cat $track_exercise_version_file_path)

    if [ "$track_data_version" = "$canonical_data_version" ]
    then
        # echo "$slug: up-to-date."
        continue
    else
        update_needed_count=$((update_needed_count + 1))
        echo "$slug: needs update (v$track_data_version -> v$canonical_data_version)."
    fi

done

if [ $update_needed_count -eq 0 ]
then
    echo "All exercises are up to date!"
fi
