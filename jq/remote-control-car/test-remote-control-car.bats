#!/usr/bin/env bats
load bats-extra

assert_key_value() {
    local expected=$1 key=$2
    local result
    result=$(echo "$output" | jq -r --arg key "$key" --argjson val "$expected" '.[$key] == $val')
    [[ $result == "true" ]]
}

@test "new car" {
    ## task 1
    run jq -n '
        include "remote-control-car";
        new_remote_control_car
    '
    assert_success
    assert_key_value 100    "battery_percentage"
    assert_key_value 0      "distance_driven_in_meters"
    assert_key_value "null" "nickname"
}

@test "new car with nickname" {
    ## task 2
    run jq -n '
        include "remote-control-car";
        new_remote_control_car("Red")
    '
    assert_success
    assert_key_value 100     "battery_percentage"
    assert_key_value 0       "distance_driven_in_meters"
    assert_key_value '"Red"' "nickname"
}

@test "display distance for new car is zero" {
    ## task 3
    run jq -r -n '
        include "remote-control-car";
        new_remote_control_car | display_distance
    '
    assert_success
    assert_output '0 meters'
}

@test "display distance for car with some distance" {
    ## task 3
    run jq -r -n '
        include "remote-control-car";
        new_remote_control_car
        | .distance_driven_in_meters += 20
        | display_distance
    '
    assert_success
    assert_output '20 meters'
}

@test "display battery for new car is 100%" {
    ## task 4
    run jq -r -n '
        include "remote-control-car";
        new_remote_control_car | display_battery
    '
    assert_success
    assert_output 'Battery at 100%'
}

@test "display battery for car with some usage" {
    ## task 4
    run jq -r -n '
        include "remote-control-car";
        new_remote_control_car
        | .battery_percentage -= 40
        | display_battery
    '
    assert_success
    assert_output 'Battery at 60%'
}

@test "display battery for car with empty battery" {
    ## task 4
    run jq -r -n '
        include "remote-control-car";
        new_remote_control_car
        | .battery_percentage = 0
        | display_battery
    '
    assert_success
    assert_output 'Battery empty'
}

@test "drive a new car" {
    ## task 5
    run jq -n '
        include "remote-control-car";
        new_remote_control_car | drive
    '
    assert_success
    assert_key_value 99 "battery_percentage"
    assert_key_value 20 "distance_driven_in_meters"
}

@test "drive a car with a dead battery" {
    ## task 6
    run jq -n '
        include "remote-control-car";
        new_remote_control_car
        | drive
        | .battery_percentage = 0
        | drive
    '
    assert_success
    assert_key_value  0 "battery_percentage"
    assert_key_value 20 "distance_driven_in_meters"
}


# vim: sw=4 ts=8
