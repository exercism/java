# Robot Name

Welcome to Robot Name on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Manage robot factory settings.

When a robot comes off the factory floor, it has no name.

The first time you turn on a robot, a random name is generated in the format
of two uppercase letters followed by three digits, such as RX837 or BC811.

Every once in a while we need to reset a robot to its factory settings,
which means that its name gets wiped. The next time you ask, that robot will
respond with a new random name.

The names must be random: they should not follow a predictable sequence.
Using random names means a risk of collisions. Your solution must ensure that
every existing robot has a unique name.

It is possible to run out of robot names - once every possible robot name has been allocated then an error should be returned.

## Bonus test 

Once you get `go test` passing, you will find that there is a test in the test suite named `TestCollisions` which is skipped by default since it can take a long time. This test creates new robots until no more new names can be assigned to the robot.

To get the test to run, remove this line:
```go
t.Skip("skipping test as it can take a long time to run if solution is sub-optimal.")
```

To get this test to pass you'll have to ensure a robot's name has not been used before and that names can be allocated efficiently.

## Source

### Created by

- @soniakeys

### Contributed to by

- @alebaffa
- @bitfield
- @ekingery
- @ferhatelmas
- @h311ion
- @hilary
- @kytrinyx
- @leenipper
- @papahmsolo
- @petertseng
- @robphoenix
- @sebito91
- @tleen
- @waynr

### Based on

A debugging session with Paul Blackwell at gSchool.