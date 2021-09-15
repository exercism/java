# Exception Handling in Java

Exception Handling in Java is one of the powerful mechanism to handle errors so that the normal flow of the application can be maintained.
Good exception handling can re-route the program to give the user still a positive experience.

## Why use Exception Handling with an example

```java
public static List<Player> getPlayers() throws IOException {
    Path path = Paths.get("players.dat");
    List<String> players = Files.readAllLines(path);

    return players.stream()
      .map(Player::new)
      .collect(Collectors.toList());
}
```

This code chooses not to handle the IOException, passing it up the call stack instead. 
In an idealized environment, the code works fine.

But what might happen in production if players.dat is missing?

```log
Exception in thread "main" java.nio.file.NoSuchFileException: players.dat <-- players.dat file doesn't exist
    at sun.nio.fs.WindowsException.translateToIOException(Unknown Source)
    at sun.nio.fs.WindowsException.rethrowAsIOException(Unknown Source)
    // ... more stack trace
    at java.nio.file.Files.readAllLines(Unknown Source)
    at java.nio.file.Files.readAllLines(Unknown Source)
    at Exceptions.getPlayers(Exceptions.java:12) <-- Exception arises in getPlayers() method, on line 12
    at Exceptions.main(Exceptions.java:19) <-- getPlayers() is called by main(), on line 19
```

We must handle these conditions because they affect the flow of the application negatively and form exceptions.

## Types of Java Exceptions

There are mainly two types of exceptions: checked and unchecked. An error is considered as the unchecked exception. However, according to Oracle, there are three types of exceptions namely:

1. Checked Exception
2. Unchecked Exception
3. Error

### 1. Checked Exception
The classes that directly inherit the Throwable class except RuntimeException and Error are known as checked exceptions. 
For example, IOException, SQLException, etc. Checked exceptions are checked at compile-time.

### 2. Unchecked Exception
The classes that inherit the RuntimeException are known as unchecked exceptions. 
For example, ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException, etc. 
Unchecked exceptions are not checked at compile-time, but they are checked at runtime.

### 3. Error
Error is irrecoverable. 
Some example of errors are OutOfMemoryError, VirtualMachineError, AssertionError etc.

## Handling Exceptions

### Try-Catch block

The `try` statement allows you to define a block of code to be tested for errors while it is being executed.

The `catch` statement allows you to define a block of code to be executed, if an error occurs in the try block.

For example:
```java
public int getPlayerScore(String playerFile) {
    try {
        Scanner contents = new Scanner(new File(playerFile));
        return Integer.parseInt(contents.nextLine());
    } catch (FileNotFoundException noFile) {
        throw new IllegalArgumentException("File not found", noFile);
    }
}
```

### The Throw/Throws keyword

If a method does not handle a checked exception, the method must declare it using the `throws` keyword. 
The `throws` keyword appears at the end of a method's signature.

You can throw an exception, either a newly instantiated one or an exception that you just caught, by using the `throw` keyword.

#### Example
```java
import java.io.*;
public class className {

   public void deposit(double amount) throws RemoteException {
      // Method implementation
      throw new RemoteException();
   }
   // Remainder of class definition
}
```

### Finally

The `finally` statement (optional) lets you execute code, after `try...catch`, **regardless of the result**.

#### Example

```java
public class Main {
  public static void main(String[] args) {
    try {
      int[] myNumbers = {1, 2, 3};
      System.out.println(myNumbers[10]);
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    } finally {
      System.out.println("The 'try catch' is finished.");
    }
  }
}
```

The output will be:

```
Something went wrong.
The 'try catch' is finished. 
```

## User-Defined Exceptions

You can create your own exceptions in Java. 
Keep the following points in mind when writing your own exception classes −

* All exceptions must be a child of Throwable.

* If you want to write a checked exception that is automatically enforced by the Handle or Declare Rule, you need to extend the Exception class.

* If you want to write a runtime exception, you need to extend the RuntimeException class.

We can define our own Exception class as below:

```java
class MyException extends Exception {
}
```