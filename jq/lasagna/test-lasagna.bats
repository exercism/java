#!/usr/bin/env bats
load bats-extra

assert_key_value() {
    local result
    result=$(echo "$output" | jq -r --arg key "$2" --argjson val "$1" '.[$key] == $val')
    [[ $result == "true" ]]
}

@test "Expected minutes in oven" {
    ## task 1
    run jq -f lasagna.jq --null-input
    assert_success
    assert_key_value 40 "expected_minutes_in_oven"
}

@test "Calculate the remaining minutes in oven" {
    ## task 2
    run jq -f lasagna.jq <<END_INPUT
      {
        "actual_minutes_in_oven": 25
      }
END_INPUT
    assert_success
    assert_key_value 15 "remaining_minutes_in_oven"
}

@test "Calculate the remaining minutes in oven, not yet started" {
    ## task 2
    run jq -f lasagna.jq --null-input
    assert_success
    assert_key_value 40 "remaining_minutes_in_oven"
}

@test "Calculate the preparation time with one layer" {
    ## task 3
    run jq -f lasagna.jq <<END_INPUT
      {
        "number_of_layers": 1
      }
END_INPUT
    assert_success
    assert_key_value 2 "preparation_time"
}

@test "Calculate the preparation time with four layers" {
    ## task 3
    run jq -f lasagna.jq <<END_INPUT
      {
        "number_of_layers": 4
      }
END_INPUT
    assert_success
    assert_key_value 8 "preparation_time"
}

@test "Total time elapsed with one layers" {
    ## task 4
    run jq -f lasagna.jq <<END_INPUT
      {
        "actual_minutes_in_oven": 30,
        "number_of_layers": 1
      }
END_INPUT
    assert_success
    assert_key_value 32 "total_time"
}

@test "Total time elapsed with four layers" {
    ## task 4
    run jq -f lasagna.jq <<END_INPUT
      {
        "number_of_layers": 4,
        "actual_minutes_in_oven": 10
      }
END_INPUT
    assert_success
    assert_key_value 18 "total_time"
}

# vim: sw=4 ts=8
