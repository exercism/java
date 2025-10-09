# Introduction

In Bank Account, you are tasked with implementing a number of operations that can be performed on a bank account.
However, these operations may be performed by multiple threads at the same time.

## General guidance

The key to solving Bank Account is to prevent an account from being updated from multiple threads at the same time.
For example, consider an account that begins with $0.
A $10 deposit is made twice.
Each transaction starts a thread.
If the threads happen to start simultaneously, they might both see the account starting $0.
They each add $10 to this amount and update the account accordingly.
In this case, each thread sets the amount to $10 even though the transaction was made twice.

The problem here is that both threads saw that there was $0 in the account prior to adding the deposit.
Instead, each thread needs to take turns to process the deposit for the account so that they can process the transaction one at a time.
This way, the later thread can "see" the deposited amount from the first thread.

## Approach: Synchronized methods

```java
class BankAccount {
    private int balance = 0;
    private boolean isClosed = true;

    synchronized void open() throws BankAccountActionInvalidException {
        if (!isClosed) {
            throw new BankAccountActionInvalidException("Account already open");
        }
        isClosed = false;
        balance = 0;
    }

    synchronized void close() throws BankAccountActionInvalidException {
        if (isClosed) {
            throw new BankAccountActionInvalidException("Account not open");
        }
        isClosed = true;
    }

    synchronized int getBalance() throws BankAccountActionInvalidException {
        checkIfClosed();
        return balance;
    }

    synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        checkIfClosed();
        checkIfValidAmount(amount);

        balance += amount;
    }

    synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        checkIfClosed();
        checkIfValidAmount(amount);
        checkIfEnoughMoneyInAccount(amount);

        balance -= amount;
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

For more information, check the [Synchronized methods approach][approach-synchronized-methods].

## Approach: Synchronized statements

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

For more information, check the [Synchronized statements approach][approach-synchronized-statements].

## Approach: Reentrant lock

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

For more information, check the [Reentrant lock approach][approach-reentrant-lock].

## Approach: Read write lock

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

For more information, check the [Read write lock approach][approach-read-write-lock].

## Which approach to use?

- The synchronized methods is the simplest, requiring no extra objects to be created.
- Synchronized statements provide greater control over which code statements are performed with a lock and which object is to be used as the lock.
- The read write lock allows greater concurrency by letting multiple read operations, such as `getBalance`, run in parallel.
  However, it requires the lock to be explicitly released.

[approach-read-write-lock]: https://exercism.org/tracks/java/exercises/bank-account/approaches/readwrite-lock
[approach-reentrant-lock]: https://exercism.org/tracks/java/exercises/bank-acconuunt/approaches/reentrant-lock
[approach-synchronized-methods]: https://exercism.org/tracks/java/exercises/bank-account/approaches/synchronized-methods
[approach-synchronized-statements]: https://exercism.org/tracks/java/exercises/bank-account/approaches/synchronzied-statements
