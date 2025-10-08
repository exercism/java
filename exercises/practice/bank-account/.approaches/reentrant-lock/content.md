# Reentrant Lock

```java
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {

    private final ReentrantLock lock = new ReentrantLock();

    private boolean isOpen = false;
    private int balance = 0;

    void open() throws BankAccountActionInvalidException {
        lock.lock();
        try {
            if (isOpen) {
                throw new BankAccountActionInvalidException("Account already open");
            }
            isOpen = true;
            balance = 0;
        } finally {
            lock.unlock();
        }
    }

    void close() throws BankAccountActionInvalidException {
        lock.lock();
        try {
            if (!isOpen) {
                throw new BankAccountActionInvalidException("Account not open");
            }
            isOpen = false;
        } finally {
            lock.unlock();
        }
    }

    int getBalance() throws BankAccountActionInvalidException {
        lock.lock();
        try {
            if (!isOpen) {
                throw new BankAccountActionInvalidException("Account closed");
            }
            return balance;
        } finally {
            lock.unlock();
        }
    }

    void deposit(int amount) throws BankAccountActionInvalidException {
        lock.lock();
        try {
            if (!isOpen) {
                throw new BankAccountActionInvalidException("Account closed");
            }
            if (amount < 0) {
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    void withdraw(int amount) throws BankAccountActionInvalidException {
        lock.lock();
        try {
            if (!isOpen) {
                throw new BankAccountActionInvalidException("Account closed");
            }
            if (amount > balance) {
                throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
            }
            if (amount < 0) {
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

}
```

A [ReentrantLock][docs-reentrantlock] object represents a lock that threads must acquire to perform certain operations.
It is used here by the operation methods to ensure they are not trying to update the bank account at the same time.

The lock is requested by calling [lock][docs-reentrantlock-lock].
The lock is released at the end of the operation by calling [unlock][docs-reentrantlock-unlock] in a `finally` block.
This is important to ensure that the lock is released when it is no longer needed, especially if an exception is thrown.
The re-entrant nature of the lock means a thread will be granted a lock again if it already has the lock.

[docs-reentrantlock]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/concurrent/locks/ReentrantLock.html
[docs-reentrantlock-lock]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/concurrent/locks/ReentrantLock.html#lock()
[docs-reentrantlock-unlock]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/concurrent/locks/ReentrantLock.html#unlock()
