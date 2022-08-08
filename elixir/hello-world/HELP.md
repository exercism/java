# Help

## Running the tests

From the terminal, change to the base directory of the exercise then execute the tests with:

```bash
$ mix test
```

This will execute the test file found in the `test` subfolder -- a file ending in `_test.exs`

Documentation:

* [`mix test` - Elixir's test execution tool](https://hexdocs.pm/mix/Mix.Tasks.Test.html)
* [`ExUnit` - Elixir's unit test library](https://hexdocs.pm/ex_unit/ExUnit.html)

## Pending tests

In test suites of practice exercises, all but the first test have been tagged to be skipped.

Once you get a test passing, you can unskip the next one by commenting out the relevant `@tag :pending` with a `#` symbol.

For example:

```elixir
# @tag :pending
test "shouting" do
  assert Bob.hey("WATCH OUT!") == "Whoa, chill out!"
end
```

If you wish to run all tests at once, you can include all skipped test by using the `--include` flag on the `mix test` command:

```bash
$ mix test --include pending
```

Or, you can enable all the tests by commenting out the `ExUnit.configure` line in the file `test/test_helper.exs`.

```elixir
# ExUnit.configure(exclude: :pending, trace: true)
```

## Useful `mix test` options

* `test/<FILE>.exs:LINENUM` - runs only a single test, the test from `<FILE>.exs` whose definition is on line `LINENUM`
* `--failed` - runs only tests that failed the last time they ran
* `--max-failures` - the suite stops evaluating tests when this number of test failures
is reached
* `--seed 0` - disables randomization so the tests in a single file will always be ran
in the same order they were defined in

## Submitting your solution

You can submit your solution using the `exercism submit lib/hello_world.ex` command.
This command will upload your solution to the Exercism website and print the solution page's URL.

It's possible to submit an incomplete solution which allows you to:

- See how others have completed the exercise
- Request help from a mentor

## Need to get help?

If you'd like help solving the exercise, check the following pages:

- The [Elixir track's documentation](https://exercism.org/docs/tracks/elixir)
- [Exercism's support channel on gitter](https://gitter.im/exercism/support)
- The [Frequently Asked Questions](https://exercism.org/docs/using/faqs)

Should those resources not suffice, you could submit your (incomplete) solution to request mentoring.

If you're stuck on something, it may help to look at some of the [available resources](https://exercism.org/docs/tracks/elixir/resources) out there where answers might be found.
If you can't find what you're looking for in the documentation, feel free to ask help in the Exercism's BEAM [gitter channel](https://gitter.im/exercism/xerlang).