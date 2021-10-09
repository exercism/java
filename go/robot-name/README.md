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

## Bonus exercise

Once you get `go test` passing, try `go test -tags bonus`.  This uses a *build
tag* to enable a test that wasn't previously enabled. Build tags control which
files should be included in the package. You can read more about those at [the
Go documentation](https://golang.org/pkg/go/build/#hdr-Build_Constraints).

For this exercise it limits `go test` to only build the tests in the
`robot_name_test.go` file. We can then include the bonus test in the
`bonus_test.go` file with the tags flag as described above.

To get the bonus test to pass you'll have to ensure a robot's name has not been
used before.

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