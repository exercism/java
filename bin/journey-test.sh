#!/usr/bin/env bash

TRACK=java
TRACK_REPO="$TRACK"
TRACK_SRC_EXT="java"
EXERCISES_TO_SOLVE=$@

on_exit() {
    echo ">>> on_exit()"
    cd $EXECPATH
    echo "<<< on_exit()"
}

assert_installed() {
    local binary=$1
    echo ">>> assert_installed(binary=\"${binary}\")"
    
    if [[ "`which $binary`" == "" ]]; then
        echo "${binary} not found; it is required to perform this test."
        echo -e "Have you completed the setup instructions at https://github.com/exercism/${TRACK_REPO} ?\n"
        echo "PATH=${PATH}"
        echo "aborting."
        exit 1
    fi
    echo "<<< assert_installed()"
}

clean() {
    local build_dir="$1"
    echo ">>> clean(build_dir=\"${build_dir}\")"
    
    # empty, absolute path, or parent reference are considered dangerous to rm -rf against.
    if [[ "${build_dir}" == "" || ${build_dir} =~ ^/ || ${build_dir} =~ \.\. ]] ; then
        echo "Value for build_dir looks dangerous.  Aborting."
        exit 1
    fi
    
    local build_path=$( pwd )/${build_dir}
    if [[ -d "${build_path}" ]] ; then
        echo "Cleaning journey script build output directory (${build_path})."
        rm -rf "${build_path}"
    fi
    cd exercises
    "$EXECPATH"/gradlew clean
    cd ..
    echo "<<< clean()"
}

solve_exercise() {
    local exercise="$1"

    echo -e "\n\n"
    echo "=================================================="
    echo "Solving ${exercise}"
    echo "=================================================="

    mkdir -p ${exercism_exercises_dir}/${TRACK}/${exercise}/src/main/java/
    mkdir -p ${exercism_exercises_dir}/${TRACK}/${exercise}/src/test/java/
    cp ${track_root}/exercises/${exercise}/build.gradle ${exercism_exercises_dir}/${TRACK}/${exercise}/build.gradle
    cp -R -H ${track_root}/exercises/${exercise}/.meta/src/reference/${TRACK}/* ${exercism_exercises_dir}/${TRACK}/${exercise}/src/main/${TRACK}/
    cp -R -H ${track_root}/exercises/${exercise}/src/test/${TRACK}/* ${exercism_exercises_dir}/${TRACK}/${exercise}/src/test/${TRACK}/
    
    pushd ${exercism_exercises_dir}/${TRACK}/${exercise}
    # Check that tests compile before we strip @Ignore annotations
    "$EXECPATH"/gradlew compileTestJava
    # Ensure we run all the tests (as delivered, all but the first is @Ignore'd)
    for testfile in `find . -name "*Test.${TRACK_SRC_EXT}"`; do
        # Strip @Ignore annotations to ensure we run the tests (as delivered, all but the first is @Ignore'd).
        # Note that unit-test.sh also strips @Ignore annotations via the Gradle task copyTestsFilteringIgnores.
        # The stripping implementations here and in copyTestsFilteringIgnores should be kept consistent.
        sed 's/@Ignore\(\(.*\)\)\{0,1\}//' ${testfile} > "${tempfile}" && mv "${tempfile}" "${testfile}"
    done
    "$EXECPATH"/gradlew test
    popd
}

solve_all_exercises() {
    local exercism_exercises_dir="$1"
    echo ">>> solve_all_exercises(exercism_exercises_dir=\"${exercism_exercises_dir}\")"
    
    local track_root=$( pwd )
    local exercises=`cat config.json | jq '.exercises[].slug + " "' --join-output`
    local total_exercises=`cat config.json | jq '.exercises | length'`
    local current_exercise_number=1
    local tempfile="${TMPDIR:-/tmp}/journey-test.sh-unignore_all_tests.txt"

    mkdir -p ${exercism_exercises_dir}
    pushd ${exercism_exercises_dir}

    for exercise in $exercises; do
        echo -e "\n\n"
        echo "=================================================="
        echo "${current_exercise_number} of ${total_exercises} -- ${exercise}"
        echo "=================================================="
        
        solve_exercise "${exercise}"
        
        current_exercise_number=$((current_exercise_number + 1))
    done
    popd
}

solve_single_exercise() {
    local exercism_exercises_dir="$1"
    local exercise_to_solve="$2"
    echo ">>> solve_single_exercises(exercism_exercises_dir=\"${exercism_exercises_dir}\", exercise_to_solve=\"$exercise_to_solve\")"
    
    local track_root=$( pwd )
    local tempfile="${TMPDIR:-/tmp}/journey-test.sh-unignore_all_tests.txt"
    
    mkdir -p ${exercism_exercises_dir}
    pushd ${exercism_exercises_dir}
    
    solve_exercise "${exercise_to_solve}"
    
    popd
}

main() {
    # all functions assume current working directory is repository root.
    cd "${SCRIPTPATH}/.."
    
    local track_root=$( pwd )
    local build_dir="build"
    local build_path="${track_root}/${build_dir}"
    
    local exercism_home="${build_path}/exercism"
    
    # fail fast if required binaries are not installed.
    assert_installed "jq"
    
    clean "${build_dir}"
    
    if [[ $EXERCISES_TO_SOLVE == "" ]]; then
        solve_all_exercises "${exercism_home}"
    else
        for exercise in $EXERCISES_TO_SOLVE
        do solve_single_exercise "${exercism_home}" "${exercise}"
        done
    fi
}

##########################################################################
# Execution begins here...

# If any command fails, fail the script.
set -ex
SCRIPTPATH=$( pushd `dirname $0` > /dev/null && pwd && popd > /dev/null )
EXECPATH=$( pwd )
# Make output easier to read in CI
TERM=dumb

trap on_exit EXIT
main

