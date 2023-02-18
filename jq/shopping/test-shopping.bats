#!/usr/bin/env bats
load bats-extra

@test "Show shopping list name" {
    ## task 1
    run jq -f shopping.jq shopping-list.json
    assert_success
    assert_line --index 0 '"Ingredients for pancakes"'
}

@test "Count the ingredients" {
    ## task 2
    run jq -f shopping.jq shopping-list.json
    assert_success
    assert_line --index 1 '8'
}

@test "Show how much sugar is needed" {
    ## task 3
    run jq -f shopping.jq shopping-list.json
    assert_success
    assert_line --index 2 '0.25'
}

@test "Map of substitutions" {
    ## task 4
    run jq -c -f shopping.jq shopping-list.json
    assert_success
    assert_line --index 3 '{"buttermilk":"regular milk","melted butter":"vegetable oil","blueberries":"chopped apple"}'
}
