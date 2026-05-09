#!/usr/bin/env bash
set -eo pipefail

# Determine the base branch of the PR
BASE_BRANCH=${GITHUB_BASE_REF:-main}

# Fetch full history for proper diff
git fetch origin "$BASE_BRANCH"

# Compute merge base
MERGE_BASE=$(git merge-base HEAD origin/"$BASE_BRANCH")

# Get changed files relative to merge base
changed_files=$(git diff --name-only "$MERGE_BASE" HEAD)

# Function to check if Gradle build files changed and run a command
check_gradle_changes() {
  local command="$1"
  local message="$2"
  
  if echo "$changed_files" | grep -qE '(\.gradle|gradlew|\.bat|settings\.gradle|gradle-wrapper\.(properties|jar))$'; then
    echo "$message"
    eval "$command"
    exit 0
  fi
}

# Extract unique exercise directories
get_changed_exercises() {
  echo "$changed_files" | \
    grep -E '^exercises/(practice|concept)/[^/]+/.+\.java$' | \
    cut -d/ -f1-3 | sort -u || true
}

# Variable for reuse
changed_exercises=$(get_changed_exercises)
