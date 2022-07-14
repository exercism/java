#!/bin/bash

print_usage() {
    echo ">>>>> Usage: ./create_issues_versionchange_canonical.sh -t path/to/track -s path/to/problem/specifications"
}

# Execution begins

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

track_exercise_slugs=$(jq '.exercises[] | select(has("deprecated") | not) | .slug' "$config_file_path" | tr -d "\"" | sort)
update_needed_count=0


# Create a file named ".exercism-version-update-issue-script-settings.sh"
# with the following variables and put in in your home directory
#
# TOKEN="your_token"
# OWNER="your_username"
# REPO="repo_name"

if ! [[ -f "$HOME/.exercism-version-update-issue-script-settings.sh" ]]; then
    echo "Create a file named \".exercism-version-update-issue-script-settings.sh\""
    echo "with the following variables and put in in your home directory"
    echo "TOKEN=\"your_token\""
    echo "OWNER=\"repo_owner\""
    echo "REPO=\"repo_name\""
fi

. "$HOME/.exercism-version-update-issue-script-settings.sh"

if [[ -z "$TOKEN" ]]; then
    echo "Please insert your personal token into \".exercism-version-update-issue-script-settings.sh\"."
    exit 1
elif [[ -z "$OWNER" ]]; then
    echo "Please insert the repo owner into \".exercism-version-update-issue-script-settings.sh\"."
    exit 1
elif [[ -z "$REPO" ]]; then
    echo "Please insert the name of the repo into \".exercism-version-update-issue-script-settings.sh\"."
    exit 1
fi


# Fetch issues opened by us to avoid duplicate issues
OPEN_ISSUES=$(curl --silent -HAuthorization:token\ ${TOKEN} https://api.github.com/repos/${OWNER}/${REPO}/issues\?state=open\&labels=exercise+version+update | jq -r '.[] |(.title | split(":")[0]) + " Issue Title: " + .title + " (" + (.comments|tostring) +" comments)" + ", URL: " + .html_url')

# Check each exercise for possible difference in version and check for submission of new issue
for slug in $track_exercise_slugs; do
    canonical_data_folder_path="${path_to_problem_specifications}/exercises/${slug}"

    if ! [[ -d "$canonical_data_folder_path" ]]; then
        echo ">>>>> Canonical data folder ${canonical_data_folder_path} not found. Aborting."
        exit 1
    fi

    canonical_data_file_path="${canonical_data_folder_path}/canonical-data.json"

    if ! [[ -f "$canonical_data_file_path" ]]; then
        continue
    fi

    canonical_data_version=$(jq '.version' ${canonical_data_file_path} | tr -d "\"")

    track_exercise_version_file_path="${path_to_track}/exercises/${slug}/.meta/version"

    if ! [[ -f "$track_exercise_version_file_path" ]]; then
        echo ">>>>> ${slug}: needs update or version file (v${canonical_data_version})."
        update_needed_count=$((update_needed_count + 1))
        read -p "Press enter to continue."
        echo
        continue
    fi

    track_data_version=$(cat "$track_exercise_version_file_path" | sed 's/\r$//')

    if [[ "$track_data_version" = "$canonical_data_version" ]]; then
        continue
    elif echo "$OPEN_ISSUES" | grep --quiet "^$slug "; then
        echo ">>>>> ${slug}: update tests and version file (v${track_data_version} -> v${canonical_data_version})"
        echo "The following issue(s) are currently open for exercise ${slug} in ${REPO}:"
        echo "$OPEN_ISSUES" | grep "^$slug " | cut -d' ' -f2-
        echo "Please check manually if the title of one of this/these issue(s) might be changed to >> ${slug}: update tests and version file (v${track_data_version} -> v${canonical_data_version}) <<"
        read -p "Press enter to continue."
        echo
        continue
    else
        update_needed_count=$((update_needed_count + 1))
        printf ">>>>> Exercise ${slug} needs an update from v${track_data_version} -> v${canonical_data_version}\n"
        title="${slug}: update tests and version file (v${track_data_version} -> v${canonical_data_version})"
        body="The tests for the [${slug} exercise](https://github.com/exercism/java/tree/main/exercises/practice/${slug}/src/test/java) are not up-to-date with the [canonical data](https://github.com/exercism/problem-specifications/tree/main/exercises/practice/${slug}/canonical-data.json).\nTo check what has changed and if new tests have been added to the canonical data, please have a look at the [commit history](https://github.com/exercism/problem-specifications/commits/main/exercises/practice/${slug}/canonical-data.json) of the canonical data file for the exercise ${slug}.\nPlease update version and/or test file, and, if the new test(s) fail, fix the reference implementation.\nFeel free to leave a comment if you have any questions. \n\nBackground info: each exercise which has canonical data should have a version file. This file states which version of the canonical data the exercise implements. The version can be found at the top of the [canonical data file](https://github.com/exercism/problem-specifications/tree/main/exercises/practice/${slug}/canonical-data.json) for that exercise."
        labels='"good first issue", "help wanted", "exercise version update"'

        response=""
        while [[ $response != "y" && $response != "n" ]]; do
          read -r -p "Do you want to publish this new issue for exercise $slug with title: $title? [y/n] " response
        done
        echo
        if [[ $response == "y" ]]; then
          printf ">>>>> Generating new issue for exercise ${slug} with title: ${title}\n"

          curl --fail --silent -H 'Content-Type: application/json' -H 'Authorization: token '"$TOKEN"'' -X POST -d '{"title": "'"$title"'", "body": "'"$body"'", "labels": ['"$labels"']}' https://api.github.com/repos/${OWNER}/${REPO}/issues | jq -r '"New issue created at: " + .html_url'
          read -p "Press enter to continue."
          echo

          if [[ "$?" != "0" ]]; then
              echo ">>>>> Issue submission failed. Exit 1"
              exit 1
          fi
        fi
    fi
done

if [[ "$update_needed_count" = 0 ]]; then
  echo "All exercises are up to date!"
fi

echo "All exercises have been checked. Exit"
