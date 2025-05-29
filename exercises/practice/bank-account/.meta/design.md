# Design

## Analyzer

This exercise could benefit from the following rules in the [analyzer](https://github.com/exercism/java-analyzer):

- `essential`: Verify that the solution **guards `deposit`, `withdraw`, and `getBalance` with `synchronized`** to avoid
  race conditions.
- `essential`: Verify that the solution **checks the account’s open/closed state before every balance operation**
- `essential`: If the solution **allows negative amounts** in `deposit` or `withdraw`, instruct the student to reject
  them early.
- `essential`: If the solution **does not throw an exception when `amount` exceeds `balance` during withdrawal**,
  instruct the student to add this check.
- `actionable:`: If the solution **declares zero or more than one `boolean`/`Boolean` field to track account state**,
  instruct the student to use exactly one such field.