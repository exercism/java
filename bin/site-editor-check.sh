#!/usr/bin/env bash

# checks whether all classes and solution stubs are visible in the editor
# (via mentioning in the .meta/config.json)

set -e

root=$(git rev-parse --show-toplevel)

for exercise_type in 'concept' 'practice'; do
  group="${root}/exercises/${exercise_type}"
  mapfile -t exercises < <(ls "${group}")
  for exercise in "${exercises[@]}"; do
    exercise_path="${group}/${exercise}"
    config_files=$(jq '.files' < "${exercise_path}/.meta/config.json")
    declare -A files
    for file_type in 'editor' 'solution'; do
      for file in $(echo "${config_files}" | jq -r ".${file_type} | @sh"); do
        if [[ "${file}" != null ]]; then
          if [[ "${file_type}" == 'editor' && $(grep 'UnsupportedOperationException' < "${exercise_path}/${file//\'/}") != '' ]]; then
            echo "${file} should be editable"
            exit 1
          fi
          files[${file}]=true
        fi
      done
    done
    mapfile -t java_files < <(find "${exercise_path}/src/main" -type f -name '*.java')
    for java_file in "${java_files[@]}"; do
      file_location=${java_file//${exercise_path}\//}
      if [[ "${files["'${file_location}'"]}" != 'true' ]]; then
        echo "${exercise_type}/${exercise}/${file_location} is not available in the editor"
        exit 1
      fi
    done
  done
done