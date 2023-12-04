# Introduction

## Exceptions

The Java programming language uses _exceptions_ to handle errors and other exceptional events.

### What is an exception

An exception is an event that occurs during the execution of a program that disrupts the normal flow of instructions.
Exceptions are raised explicitly in Java, and the act of raising an exception is called _throwing an exception_.
The act of handling an exception is called _catching an exception_.

Java distinguishes three types of exceptions:

1. Checked exceptions
2. Unchecked exceptions
3. Errors

#### Checked exceptions

_Checked exceptions_ are exceptional conditions that an application should anticipate and recover from.
An example of a checked exception is the `FileNotFoundException` which occurs when a method is trying to read a file that does not exist.

This type of exception is checked at compile-time: methods that throw checked exceptions should specify this in their method signature, and code calling a method that might throw a checked exception is required to handle it or the code will not compile.

All exceptions in Java that do not inherit from `RuntimeException` or `Error` are considered checked exceptions.

#### Unchecked exceptions

_Unchecked exceptions_ are exceptional conditions that an application usually cannot anticipate or recover from.
An example of an unchecked exception is the `NullPointerException` which occurs when a method that is expecting a non-null value but receives `null`.

This type of exception is not checked at compile-time: methods that throw unchecked exceptions are not required to specify this in their method signature, and code calling a method that might throw an unchecked exception is not required to handle it.

All exceptions in Java that inherit from `RuntimeException` are considered unchecked exceptions.

#### Errors

_Errors_ are exceptional conditions that are external to an application.
An example of an error is the `OutOfMemoryError` which occurs when an application is trying to use more memory than is available on the system.

Like unchecked exceptions, errors are not checked at compile-time.
They are not usually thrown from application code.

All exceptions in Java that inherit from `Error` are considered errors.

### Throwing exceptions

A method in Java can throw an exception by using the `throw` statement.

#### Throwing a checked exception

When throwing a checked exception from a method, it is required to specify this in the method signature by using the `throws` keyword, as shown in the example below.
This forces calling code to anticipate that an exception might be thrown and handle it accordingly.

```java
public class InsufficientBalanceException extends Exception {

}

public class BankAccount {
  public void withdraw(double amount) throws InsufficientBalanceException {
    if (balance < amount) {
      throw new InsufficientBalanceException();
    }

    // rest of the method implementation
  }
}
```

#### Throwing an unchecked exception

When throwing an unchecked exception from a method, it is not required to specify this in the method signature - although it is supported.

```java
public class BankAccount {
  public void withdraw(double amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Cannot withdraw a negative amount");
    }

    // rest of the method implementation
  }
}
```

### Handling exceptions

Handling exceptions in Java is done with the `try`, `catch` and `finally` keywords.

- Code statements that might throw an exception should be wrapped in a `try` block.
- The `try` block is followed by one or more `catch` blocks that catch the exceptions thrown in the `try` block.
- The `catch` blocks are optionally followed by a `finally` block that always executes after the `try` block, regardless of whether an exception was thrown or not.

The following example shows how these keywords work:

```java
public class ATM {
  public void withdraw(BankAccount bankAccount, double amount) {
    try {
      System.out.println("Withdrawing " + amount);
      bankAccount.withdraw(amount);
      System.out.println("Withdrawal succeeded");
    } catch (InsufficientBalanceException) {
      System.out.println("Withdrawal failed: insufficient balance");
    } catch (RuntimeException e) {
      System.out.println("Withdrawal failed: " + e.getMessage());
    } finally {
      System.out.println("Current balance: " + bankAccount.getBalance());
    }
  }
}
```

In this example, when no exception is thrown, the following is printed:

```text
Withdrawing 10.0
Withdrawal succeeded
Current balance: 5.0
```

However, should the `bankAccount.withdraw(amount)` statement throw an `InsufficientBalanceException`, the following is printed:

```text
Withdrawing 10.0
Withdrawal failed: insufficient balance
Current balance: 5.0
```

Or, in case an unchecked exception is thrown by the `bankAccount.withdraw(amount)`, the following is printed:

```text
Withdrawing -10.0
Withdrawal failed: Cannot withdraw a negative amount
Current balance: 5.0
```
