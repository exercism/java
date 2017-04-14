#!/usr/bin/env bash

for EXERCISE_DIRECTORY in $(find exercises -mindepth 2 -maxdepth 2 -type d -name "src"); do
  STARTER_DIRECTORY="${EXERCISE_DIRECTORY}/main/java"
  STARTER_FILE_COUNT=$(find "${STARTER_DIRECTORY}" -mindepth 1 -maxdepth 1 -type f -name "*.java" | wc -l)
  KEEP_FILE_LOCATION="${STARTER_DIRECTORY}/.keep"

  if (( ${STARTER_FILE_COUNT} > 0 )) && [[ -f "${KEEP_FILE_LOCATION}" ]]; then
    echo "Removing unnecessary keep file ${KEEP_FILE_LOCATION}..."
    rm "${KEEP_FILE_LOCATION}"
  fi
done
