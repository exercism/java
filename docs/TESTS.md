# Running the Tests

* [In IntelliJ IDEA](#in-intellij-idea)
* [On the Command-Line Prompt](#on-the-command-line-prompt)
* [In Eclipse](#in-eclipse)
* [In NetBeans](#in-netbeans)

----

# In IntelliJ IDEA

If you followed the [Getting Started Fast](http://exercism.io/languages/java/installing#getting-started-fast) instructions, you are using IntelliJ IDEA to work the exercises.

There are two flavors of these instructions:

* [On Windows](#on-windows)
* [On OS X](#on-os-x)

## On Windows

1. In the Command Prompt window, get the first exercise:

   ```
   C:\Users\johndoe> exercism fetch java

   New:
   java (Hello World)      C:\Users\johndoe\exercism\java\hello-world

  unchanged: 0, updated: 0, new: 1
  ```
- Launch IntelliJ (**Start** -> **All Programs** -> **JetBrains** -> **IntelliJ IDEA Community Edition**).
- In the "Welcome to IntelliJ IDEA" window, click the "**Open**" option.
- Navigate to the "C:\Users\johndoe\exercism\java\hello-world" folder.  Make sure you've selected the "hello-world" folder. Click "**OK**".
- In the "Import Project from Gradle" dialog, check the "**auto-import**" and "**create directories**" checkboxes and select "**Use gradle wrapper task configuration**".

  ```
  Gradle project:    [C:\Users\johndoe\exercism\java\hello-world] (...)

  [X] Use auto-import
  [X] Create directories for empty content roots automatically
  [X] Create separate module per source set

  ( ) Use default gradle wrapper (not configured for the current project)
  (o) Use gradle wrapper task configuration
  ( ) Use local gradle distribution
  ```
- Click "**OK**".  IntelliJ will automatically create its project artifacts based on the Gradle project file.
  - After the project has loaded and you've dismissed the "Tip of the Day" dialog, you may see a notice (in the top-right-hand corner), saying, "Unindex remote maven repositories found." you can safely dismiss this notice.
  - If the workspace appears empty, open the Project View (**View** -> **Tool Windows** -> **Project**).
- Open the `README.md` file and carefully read the background for the assignment.
  - When you do, IntelliJ will offer to install a plugin to view Markdown (`.md`) files.
    1. Install the suggested plugins.
    -  When the install finishes, a notice pops-up.  Click the "Restart" link.
    -  When IntelliJ restarts, you'll find the `README.md` now has an additional tab at the bottom of the editor, "HTML Preview" click that tab to view the rendered version of the Markdown.
- Start by running the test suite: In the "Project" view, right-click on the test file (`hello-world\src\test\java\HelloWorldTest`), select "**Run**".
 * If these menu options don't appear at first, wait for a moment and try again; IntelliJ is still configuring the project with a Java nature.
- When you first start an exercise, you should expect compilation errors because the test is setting expectations on a class that you need to write.  By trying to run the tests, you get a nice list of what needs to be fixed in the "Messages Make" view.
- Open `GETTING_STARTED.md` for a walk-through on solving the first exercise.  The instructions are written for the command-line setup, but the fixes to the code apply, regardless.

Good luck!  Have fun!

If you get stuck, at any point, don't forget to reach out for [help](http://exercism.io/languages/java/help).

----

## On OS X

1. In the terminal window, get the first exercise:

   ```
   $ exercism fetch java

   New:                 1 problem
   Java (Etl) /Users/johndoe/exercism/java/hello-world

   unchanged: 0, updated: 0, new: 1
  ```
- Launch IntelliJ (in the Dock, click on Launchpad and find "**IntelliJ IDEA**")
- In the "Welcome to IntelliJ IDEA" window, click the "**Open**" option.
- Navigate to the `/Users/johndoe/exercism/java/hello-world`.  Make sure you've selected the `hello-world` folder. Click "**OK**".
- In the "Import Project from Gradle" dialog, check the "**auto-import**" and "**create directories**" checkboxes and select "**Use gradle wrapper task configuration**".

  ```
  Gradle project:    [/Users/johndoe/exercism/java/hello-world] (...)

  [X] Use auto-import
  [X] Create directories for empty content roots automatically
  [X] Create separate module per source set

  ( ) Use default gradle wrapper (not configured for the current project)
  (o) Use gradle wrapper task configuration
  ( ) Use local gradle distribution
  ```
- Click "**OK**".  IntelliJ will automatically create its project artifacts based on the Gradle project file.
  - After the project has loaded and you've dismissed the "Tip of the Day" dialog, you may see a notice (in the top-right-hand corner), saying, "Unindex remote maven repositories found." you can safely dismiss this notice.
  - If the workspace appears empty, open the Project View (**View** -> **Tool Windows** -> **Project**).
- Open the `README.md` file and carefully read the background for the assignment.
  - When you do, IntelliJ will offer to install a plugin to view Markdown (`.md`) files.
    1. Install the suggested plugins.
    -  When the install finishes, a notice pops-up.  Click the "Restart" link.
    -  When IntelliJ restarts, you'll find the `README.md` now has an additional tab at the bottom of the editor, "HTML Preview" click that tab to view the rendered version of the Markdown.
- Start by running the test suite: In the "Project" view, right-click on the test file (`hello-world/src/test/java/HelloWorldTest`), select "**Run**".
 * If these menu options don't appear at first, wait for a moment and try again; IntelliJ is still configuring the project with a Java nature.
- When you first start an exercise, you should expect compilation errors because the test is setting expectations on a class that you need to write.  By trying to run the tests, you get a nice list of what needs to be fixed in the "Messages Make" view.
- Open `GETTING_STARTED.md` for a walk-through on solving the first exercise.  The instructions are written for the command-line setup, but the fixes to the code apply, regardless.

Good luck!  Have fun!

If you get stuck, at any point, don't forget to reach out for [help](http://exercism.io/languages/java/help).

----

# On the Command-Line Prompt

If you followed the [Command-Line Development Setup](http://exercism.io/languages/java/installing#command-line-development-setup) instructions, you are using the JDK and Gradle, directly.


1. In the terminal window, get the first exercise:

   ```
   $ exercism fetch java

   New:                 1 problem
   Java (Etl) /Users/johndoe/exercism/java/hello-world

   unchanged: 0, updated: 0, new: 1

  ```
- Change directory into the exercise:

   ```
   $ cd /Users/johndoe/exercism/java/hello-world
   ```
- Run the tests:

  ```
  $ gradle test
  ```
- Solve the exercise.  Find and work through the `GETTING_STARTED.md` guide ([view on GitHub](https://github.com/exercism/xjava/blob/master/exercises/hello-world/GETTING_STARTED.md)).

Good luck!  Have fun!

If you get stuck, at any point, don't forget to reach out for [help](http://exercism.io/languages/java/help).

----

# In Eclipse

> **Help Wanted**
>
> These instructions lack specificity.  Can you help?  If so, please see how to contribute to documentation, at the bottom of this page.

If you followed the [Installing Eclipse](http://exercism.io/languages/java/installing#installing-eclipse) instructions, you are using Eclipse to work the exercises.

1. In the Command Prompt window, get the first exercise:

   ```
   C:\Users\johndoe> exercism fetch java

   New:
   java (Hello World)      C:\Users\johndoe\exercism\java\hello-world

  unchanged: 0, updated: 0, new: 1
  ```
- In Eclipse, from the "**File**" menu select "**Import**".
- Select "**Gradle**" > "**Gradle Project**" as your import source.
- Browse to the directory containing the exercise fetched during the step 1 to a text field labeled "Project root directory".
- Hit the button labeled "**Finish**".
- Run the tests in the project.
  * When you first start an exercise, you should expect compilation errors because the test is
    setting expectations on a class that you need to write.  By trying to run the tests, you get a
    nice list of what needs to be fixed.
- Open `GETTING_STARTED.md` for a walk-through on solving the first exercise.  The instructions are written for the command-line setup, but the fixes to the code apply, regardless.

Good luck!  Have fun!

If you get stuck, at any point, don't forget to reach out for [help](http://exercism.io/languages/java/help).

----

# In NetBeans

> **Help Wanted**
>
> These instructions lack specificity.  Can you help?  If so, please see how to contribute to documentation, at the bottom of this page.

If you followed the [Installing NetBeans](http://exercism.io/languages/java/installing#installing-netbeans) instructions, you are using NetBeans to work the exercises.

1. In the Command Prompt window, get the first exercise:

   ```
   C:\Users\johndoe> exercism fetch java

   New:
   java (Hello World)      C:\Users\johndoe\exercism\java\hello-world

  unchanged: 0, updated: 0, new: 1
  ```
- Import the project through the Gradle NetBeans plugin.  Documentation is available at https://github.com/kelemen/netbeans-gradle-project/wiki
- Run the tests in the project.
  * When you first start an exercise, you should expect compilation errors because the test is
    setting expectations on a class that you need to write.  By trying to run the tests, you get a
    nice list of what needs to be fixed.
- Open `GETTING_STARTED.md` for a walk-through on solving the first exercise.  The instructions are written for the command-line setup, but the fixes to the code apply, regardless.

Good luck!  Have fun!

If you get stuck, at any point, don't forget to reach out for [help](http://exercism.io/languages/java/help).
