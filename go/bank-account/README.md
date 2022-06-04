# Bank Account

Welcome to Bank Account on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Simulate a bank account supporting opening/closing, withdrawals, and deposits
of money. Watch out for concurrent transactions!

A bank account can be accessed in multiple ways. Clients can make
deposits and withdrawals using the internet, mobile phones, etc. Shops
can charge against the account.

Create an account that can be accessed from multiple threads/processes
(terminology depends on your programming language).

It should be possible to close an account; operations against a closed
account must fail.

## Instructions

Run the test file, and fix each of the errors in turn. When you get the
first test to pass, go to the first pending or skipped test, and make
that pass as well. When all of the tests are passing, feel free to
submit.

Remember that passing code is just the first step. The goal is to work
towards a solution that is as readable and expressive as you can make
it.

Have fun!

## Implementation Notes

If Open is given a negative initial deposit, it must return nil.
Deposit must handle a negative amount as a withdrawal. Withdrawals must
not succeed if they result in a negative balance.
If any Account method is called on an closed account, it must not modify
the account and must return ok = false.

The tests will execute some operations concurrently. You should strive
to ensure that operations on the Account leave it in a consistent state.
For example: multiple goroutines may be depositing and withdrawing money
simultaneously, two withdrawals occurring concurrently should not be able
to bring the balance into the negative.

When working locally, you can test that your code handles concurrency properly and does not introduce
data races, run tests with `-race` flag on.

```bash
$ cd exercism/project/directory/go/bank-account
$ go test -race
```

If you are new to concurrent operations in Go it will be worth looking
at the sync package, specifically Mutexes:

https://golang.org/pkg/sync/
https://tour.golang.org/concurrency/9
https://gobyexample.com/mutexes

## Source

### Created by

- @soniakeys

### Contributed to by

- @alebaffa
- @bitfield
- @ekingery
- @ferhatelmas
- @hilary
- @homelinen
- @JensChrG
- @juergenhoetzel
- @kytrinyx
- @leenipper
- @parroty
- @petertseng
- @robphoenix
- @sebito91
- @tleen