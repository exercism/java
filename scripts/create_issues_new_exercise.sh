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
track_exercise_slugs=$(jq '.exercises[] | select(has("deprecated") | not) | .slug' "$config_file_path" | tr -d "\"" | sort)
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
open_issues=$(curl --silent -HAuthorization:token\ ${TOKEN} https://api.github.com/repos/${OWNER}/${REPO}/issues\?state=open\&labels=implement+exercise | jq -r '.[] |(.title | split(":")[0]) + " Issue Title: " + .title + " (" + (.comments|tostring) +" comments)" + ", URL: " + .html_url')

count=0
for exercise in $problem_spec_exercises; do
  if echo "$track_exercise_slugs" | grep -q "$exercise" ; then
    continue
  elif echo "$track_deprecated_exercises" | grep -q "$exercise"; then
    continue
  elif echo "$track_foregone_exercises" | grep -q "$exercise"; then
    continue
  fi
  (( count+=1 ))
    if echo "$open_issues" | grep --quiet "^$exercise "; then
        echo ">>>>> $exercise: implement exercise"
        echo "The following issue(s) are currently open for exercise $exercise in ${REPO} with label <implement exercise>:"
        echo "$open_issues" | grep "^$exercise " | cut -d' ' -f2-
        echo "Please check manually if a new issue may be opened."
        read -p "Press enter to continue."
        echo
        continue
    else
        printf ">>>>> Exercise $exercise is not yet implemented in the Java track.\n"
        title="$exercise: implement exercise"
        body="The exercise **$exercise** has not been implemented yet for the Java track. \nThe description of the exercise can be found in the [problem specification repository](https://github.com/exercism/problem-specifications/tree/main/exercises/practice/$exercise). \n\nHow to implement a new exercise for the Java track is described in detail in [CONTRIBUTING.md](https://github.com/exercism/java/blob/main/CONTRIBUTING.md#adding-a-new-exercise). Please have a look there first before starting working on the exercise. \nAlso please make sure it is clear that you are currently working on this issue, either by asking to be assigned to it, or by opening an empty PR. \n\nWhen opening an PR, please reference this issue using any of the [closing keywords](https://help.github.com/en/articles/closing-issues-using-keywords). \n\nIf you have had a look at the exercise description and you concluded that the exercise might not be possible to implement in the Java language, please leave a comment and describe the problem. \n\nIn case you have any further questions, feel free to ask here. \n"
        labels='"help wanted", "implement exercise", "enhancement"'

        response=""
        while [[ $response != "y" && $response != "n" ]]; do
          read -r -p "Do you want to publish this new issue for exercise $exercise with title: $title? [y/n] " response
        done
        echo
        if [[ $response == "y" ]]; then
          printf ">>>>> Generating new issue for exercise $exercise with title: ${title}\n"

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

echo "Total: $count exercises unimplemented."
echo "All exercises checked."

exit 0
