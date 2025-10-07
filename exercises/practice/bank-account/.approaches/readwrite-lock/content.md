# Readwrite Lock

```java
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class BankAccount {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private boolean isOpen = false;

    private int balance = 0;

    void open() throws BankAccountActionInvalidException {
        lock.writeLock().lock();
        try {
            if (isOpen) {
                throw new BankAccountActionInvalidException("Account already open");
            }
            isOpen = true;
            balance = 0;
        } finally {
            lock.writeLock().unlock();
        }
    }

    void close() throws BankAccountActionInvalidException {
        lock.writeLock().lock();
        try {
            if (!isOpen) {
                throw new BankAccountActionInvalidException("Account not open");
            }
            isOpen = false;
        } finally {
            lock.writeLock().unlock();
        }
    }

    int getBalance() throws BankAccountActionInvalidException {
        lock.readLock().lock();
        try {
            if (!isOpen) {
                throw new BankAccountActionInvalidException("Account closed");
            }
            return balance;
        } finally {
            lock.readLock().unlock();
        }
    }

    void deposit(int amount) throws BankAccountActionInvalidException {
        lock.writeLock().lock();
        try {
            if (!isOpen) {
                throw new BankAccountActionInvalidException("Account closed");
            }
            if (amount < 0) {
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }
            balance += amount;
        } finally {
            lock.writeLock().unlock();
        }
    }

    void withdraw(int amount) throws BankAccountActionInvalidException {
        lock.writeLock().lock();
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
            lock.writeLock().unlock();
        }
    }
}
```

A [ReadWriteLock][docs-readwritelock] provides two types of locks - one for reading the other for writing.
[ReentrantReadWriteLock][docs-reentrantreadwritelock] is an implementation of a [ReadWriteLock][docs-readwritelock].

Read locks are intended for read only type operations, such as `getBalance`, and is acquired by calling `readLock().lock()` on the [ReadWriteLock][docs-readwritelock].
Multiple threads are allowed to acquire read locks at the same time because they are expected to only read data.
This means multiple threads can run `getBalance` at the same time.

Write locks are for write operations, such as `withdraw` and `deposit`.
It is also used in `open` and `close` as they change the state of the `BankAccount` (they "write" to the `isOpen` field).
Write locks are acquired by calling `writeLock().lock()` on the [ReadWriteLock][docs-readwritelock].

Only one thread can hold a write lock at a time.
Therefore, `withdraw`, `deposit`, `open` and `close` can not run at the same time.
Additionally, a thread must _also_ wait for _all_ read locks to be released to obtain a write lock.
Similarly, threads must wait for write locks to be released before they granted a read lock.
This means `getBalance` also can not run at the same time as any of the `withdraw`, `deposit`, `open` and `close` methods.

The locks are released in the `finally` block to ensure they are released, even when an exception is thrown.

[docs-readwritelock]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/concurrent/locks/ReadWriteLock.html
[docs-reentrantreadwritelock]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/concurrent/locks/ReentrantReadWriteLock.html
