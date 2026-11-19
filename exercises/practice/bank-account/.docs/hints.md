# Hints

## Debugging Account Balance and Deposit Arithmetic

A bank account tracks money by updating an accumulated internal balance. When implementing operations:

- **Account Lifecycle**: Newly opened accounts always start with a balance of `0`. All account operations (`deposit`, `withdraw`, `getBalance`, `close`) require the account to be open first; operating on an unopened or closed account must throw `BankAccountActionInvalidException`.
- **Deposit Arithmetic**: A deposit must add money to the account. When a deposit occurs, the amount is added to the previous balance (`balance = balance + amount`), rather than replacing it or subtracting from it.
- **Input Validation**: Neither deposits nor withdrawals may accept negative amounts. Negative amounts must be rejected by throwing `BankAccountActionInvalidException`.

### Diagnostic Input to Test Your Implementation

You can trace a minimal sequence of operations to verify that your deposit logic correctly accumulates funds:

1. Open a new account: the balance should be `0`.
2. Deposit `1` unit into the account: the balance should now be `1`.

```java
BankAccount account = new BankAccount();
account.open();
account.deposit(1);
int balance = account.getBalance(); // Expected: 1
```

If `balance` returns `-1` instead of `1`, check your arithmetic operator in the deposit method to ensure you are adding the deposited funds rather than subtracting them. If `balance` returns `0` or throws an unexpected exception, verify that the account state was marked as open before the deposit took place.
