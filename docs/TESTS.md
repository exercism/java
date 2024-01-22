# Running the Tests

Choose your operating system:

- [Windows](#windows)
- [macOS](#macos)
- [Linux](#linux)

## Windows

1. Open a Command Prompt.
2. Get the first exercise:

   ```batchfile
   C:\Users\JohnDoe>exercism download --exercise hello-world --track java
   ```

3. Change directory into the exercism:

   ```batchfile
   C:\Users\JohnDoe>cd C:\Users\JohnDoe\exercism\java\hello-world
   ```

4. Run the tests:

   ```batchfile
   C:\Users\JohnDoe>gradlew.bat test
   ```

   _(Don't worry about the tests failing, at first, this is how you begin each exercise.)_

5. Solve the exercise. Find and work through the `instructions.append.md` guide ([view on GitHub][hello-world-tutorial]).

Good luck! Have fun!

## macOS

1. In the terminal window, get the first exercise:

   ```sh
   exercism download --exercise hello-world --track java
   ```

2. Change directory into the exercise:

   ```sh
   cd /Users/johndoe/exercism/java/hello-world
   ```

3. Run the tests:

   ```sh
   ./gradlew test
   ```

   _(Don't worry about the tests failing, at first, this is how you begin each exercise.)_

4. Solve the exercise. Find and work through the `instructions.append.md` guide ([view on GitHub][hello-world-tutorial]).

Good luck! Have fun!

## Linux

1. In the terminal window, get the first exercise:

   ```sh
   exercism download --exercise hello-world --track java
   ```

2. Change directory into the exercise:

   ```sh
   cd /home/johndoe/exercism/java/hello-world
   ```

3. Run the tests:

   ```sh
   ./gradlew test
   ```

   _(Don't worry about the tests failing, at first, this is how you begin each exercise.)_

4. Solve the exercise. Find and work through the `instructions.append.md` guide ([view on GitHub][hello-world-tutorial]).

Good luck! Have fun!

[hello-world-tutorial]: https://github.com/exercism/java/blob/main/exercises/practice/hello-world/.docs/instructions.append.md#tutorial
