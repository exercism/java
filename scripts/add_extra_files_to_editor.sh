#! /usr/bin/env bash

command -v jq >/dev/null 2>&1 || {
        echo >&2 ">>>>> This script requires jq but it's not installed. Aborting."
        exit 1
}

#######################################################
################### HELP ##############################
print_usage() {
        echo -e "\nDescription:\n"
        echo -e "This script goes through each exercise directory, picks all the java files in the src directory, except the main editable solution file, and adds them to 'fonts.editor' section of the config.json file present in the .meta folder of the exercise" 
        echo -e "This makes sure that there is no need to manually configure the config.json for subsequent exercises. Just running this script will resolve all those tasks on their own."

        echo -e "\nSyntax: ./add_extra_files_to_editor.sh [-a|-h|-d <exercise_name>]"

        echo -e "\nOptions:\n"
        echo -e "h                      Display the usage of the script"
        echo -e "a                      Processes all the exercises present inside ./exercise/practice directory"
        echo -e "d <exercise_name>      Processes only the directory specified by the argument <exercise_name>." 
        echo -e "                       Do note that you only need to give the name of the exercise. Do not give the path to the exercise folder."
        echo -e "                       For example: if you need to process only the exercise 'triangle' then type '<script_name>.sh -d triangle'"
}

#######################################################
#######################################################


#######################################################
################### MAIN ##############################


# get the current location
current_location=$PWD

# get the exercises location
exercises_location="$current_location/exercises/practice"

process_current_directory() {

        java_source_dir="$exercises_location/$1/src/main/java"

        data=$(find "$java_source_dir" -type f -name "*.java")

        # now getting the config.json file and here getting the details of the solution file
        json_file="$exercises_location/$1/.meta/config.json"

        # this is the solution file here
        solution_file=$(jq '.| .files.solution[0]' $json_file)
        solution_file=${solution_file:1:-1} # removing the quotes

        # editor_files array being created here so that it will be storing the list of
        # files that will be present in the editor
        editor_files=()

        # now adding only those files to the editor which are not present in the solution
        for VAL in $data; do
                # getting the file name in a valid format so that it can be used in the json
                file_name="src/main/java/$(echo $VAL | sed "s/.*\///")"
                if [ $file_name != $solution_file ]; then
                        editor_files+=($file_name)
                fi
        done

        tmp=$(mktemp)

        # this one basically clears the editor portion of the json file
        # and assigns it with an empty list if it exists
        jq '.files.editor = []' $json_file --args "${editor_files[@]}" >"$tmp" && mv "$tmp" "$json_file"

        # this one updates the editor portion of the json
        jq '.files.editor += $ARGS.positional' $json_file --args "${editor_files[@]}" >"$tmp" && mv "$tmp" "$json_file"

        echo "Successfully processed $(basename $1)"
}

process_all_directories() {
        cd $exercises_location

        for directory in *; do
                process_current_directory $directory
        done
}


# getting the commands here
num_args=$#

if [ $num_args -eq 0 ]
then
    print_usage
    exit 0
fi

# processing the script here
while getopts ":had:" option; do
        case $option in
        h)
                print_usage
                exit 0
                ;;
        a)
                process_all_directories
                exit 0
                ;;
        d)
                process_current_directory $OPTARG
                exit 0
                ;;
        \?)
                echo "Error: Invalid operation"
                print_usage
                exit 0
                ;;

        esac
done

#######################################################
#######################################################