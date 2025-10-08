# Synchronized statements

```java
class BankAccount {
    private final Object lock = new Object();
    private int balance = 0;
    private boolean isClosed = true;

    void open() throws BankAccountActionInvalidException {
        synchronized(lock) {
            if (!isClosed) {
                throw new BankAccountActionInvalidException("Account already open");
            }
            isClosed = false;
            balance = 0;
        }
    }

    void close() throws BankAccountActionInvalidException {
        synchronized(lock) {
            if (isClosed) {
                throw new BankAccountActionInvalidException("Account not open");
            }
            isClosed = true;
        }
    }

    int getBalance() throws BankAccountActionInvalidException {
        synchronized(lock) {
            checkIfClosed();
            return balance;
        }
    }

    void deposit(int amount) throws BankAccountActionInvalidException {
        synchronized(lock) {
            checkIfClosed();
            checkIfValidAmount(amount);

            balance += amount;
        }
    }

    void withdraw(int amount) throws BankAccountActionInvalidException {
        synchronized(lock) {
            checkIfClosed();
            checkIfValidAmount(amount);
            checkIfEnoughMoneyInAccount(amount);

            balance -= amount;
        }
    }

    private void checkIfValidAmount(int amount) throws BankAccountActionInvalidException {
        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
    }

    private void checkIfEnoughMoneyInAccount(int amount) throws BankAccountActionInvalidException {
        if (balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
        if (balance - amount < 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }
    }

    private void checkIfClosed() throws BankAccountActionInvalidException {
        if (isClosed) {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }
}
```

In this approach, the operation methods, such as `open`, `close`, `deposit` and `withdraw`, perform their operations in a `synchronized` code block.
A lock is acquired on the synchronized object (`lock`) before the statements inside the block are executed.
If another thread has a lock on the object, it must wait for it to be released.
The lock is released after the block is executed.

## Using `this` as the synchronized object

Any object can be used as the lock, including `this`.
For example:

```java
int getBalance() throws BankAccountActionInvalidException {
    synchronized(this) {
        checkIfClosed();
        return balance;
    }
}
```

This is the same as using a [synchronized method][approach-synchronized-methods], which requires a lock on the same `this` object to run the method.
For example:

```java
synchronized int getBalance() throws BankAccountActionInvalidException {
    checkIfClosed();
    return balance;
}
```

When using [synchronized methods][approach-synchronized-methods] and `synchronized(this)`, it is important to keep in mind that may be trying to acquire a lock on the same instance.
For example:

```java
BankAccount account = new BankAccount();

Thread thread1 = new Thread(() -> {
    account.withdraw(5);
});

Thread thread2 = new Thread(() -> {
    synchronized (account) {
        // Code in here can not run at same time as account.withdraw in thread1. 
    }
});
```

[approach-synchronized-methods]: https://exercism.org/tracks/java/exercises/bank-account/approaches/synchronized-methods
