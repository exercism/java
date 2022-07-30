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

### Opening an account

An account can be opened.
On opening, its initial balance should not be negative.
If a negative balance is given to the `Open` function, `nil` must be returned, otherwise the newly created account must be returned.

### Closing an account

An account can be closed.
When closing an account, the `Close` method must return the balance the account has and a boolean `true` indicating the account was closed successfully.
Closing an account does not succeed if the account is already closed.
When an account is closed, its balance must be set to `0`.

### Getting the account balance

The `Balance` method allows a user to check the current balance of an account.
It must return the balance of the account and a boolean indicating if the operation succeeded.
Checking the balance only doesn't succeed if the account is closed.

### Deposits / Withrawals

Deposits and withdrawals are both handled by the `Deposit` method.
If the argument given to the method is a positive amount, then that amount of money must be deposited in the account.
If the amount given is negative, that amount of money must be withdrawn from the account.
If the account is closed, its balance must not be modified.

`Deposit` returns the new balance of the account and a boolean that indicates if the operation succeeded.
`Deposit` must fail if the account is closed or if there is not enough money to withdraw from the account.

## Testing

The tests will execute some operations concurrently.
You should strive to ensure that operations on the Account leave it in a consistent state.
For example: multiple goroutines may be depositing and withdrawing money simultaneously, two withdrawals occurring concurrently should not be able to bring the balance into the negative.

When working locally, you can test that your code handles concurrency properly and does not introduce data races, run tests with `-race` flag on.

```bash
$ cd exercism/project/directory/go/bank-account
$ go test -race
```

## Resources

If you are new to concurrent operations in Go it will be worth looking at the sync package, specifically Mutexes:

- [Official documentation for package sync](https://golang.org/pkg/sync/)
- [Tour Of Go: sync.Mutex](https://tour.golang.org/concurrency/9)
- [Go By Example: sync.Mutex](https://gobyexample.com/mutexes)

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