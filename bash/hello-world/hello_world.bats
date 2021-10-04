#!/usr/bin/env bats
load bats-extra

# local version: 1.1.0.0

@test "Say Hi!" {
  run bash hello_world.sh

  # the program's exit status should be success (0)
  assert_success

  # program's output should be the expected text
  assert_output "Hello, World!"
}
