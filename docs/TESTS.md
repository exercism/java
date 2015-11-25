## Windows

1) In the Command Prompt window, get the first exercise...

```
C:\Users\johndoe> exercism fetch java

New:
java (Etl)      C:\Users\johndoe\exercism\java\etl

unchanged: 0, updated: 0, new: 1
```

2) In the "Welcome to IntelliJ IDEA" window, click the "Open" option.

3) Navigate to the "C:\Users\johndoe\exercism\java\etl" folder.  Make sure you've selected the "etl" folder. Click "OK".

4) In the "Import Project from Gradle" dialog, check the "auto-import" and "create directories" checkboxes and select "Use customizable gradle wrapper".

```
Gradle project:    [C:\Users\johndoe\exercism\java\etl\build.gradle   ](...)

[X] Use auto-import
[X] Create directories for empty content roots automatically

( ) Use default gradle wrapper (not configured for the current project)
(o) Use customizable gradle wrapper
( ) Use local gradle distribution

...
```

5) Click "OK".  IntelliJ will automatically create its project artifacts based on the Gradle project file.

* After the project has loaded and you've dismissed the "Tip of the Day" dialog, you may see a notice (in the top-right-hand corner), saying, "Unindex remote maven repositories found." you can safely dismiss this notice.

6) Open the `README.md` file and carefully read the background for the assignment.

7) Start by running the test suite: In the "Project" view, right-click on the test file (`etl\src\test\java\EtlTest`), select "Run", then pick the "EtlTest" that has a JUnit icon to the left of it (red and green arrows), NOT the Gradle icon (circular green).

* When you first start an exercise, you should expect compilation errors because the test is setting expectations on a class that you need to write.  By trying to run the tests, you get a nice list of what needs to be fixed in the "Messages Make" view.

... and away you go!!!

## Mac OS X

### Get started with the first exercise

1. In the terminal window, get the first exercise...

        $ exercism fetch java

        Not Submitted:       1 problem
        Java (Etl) /Users/johndoe/exercism/java/etl

        New:                 1 problem
        Java (Etl) /Users/johndoe/exercism/java/etl

        unchanged: 0, updated: 0, new: 1

2. In the "Welcome to IntelliJ IDEA" window, click the "Open" option.

3. Navigate to the `/Users/johndoe/exercism/java/etl` folder.  Make sure you've selected the
   "etl" folder. Click "OK".

4. In the "Import Project from Gradle" dialog, check the "auto-import" and "create directories"
   checkboxes and select "Use customizable gradle wrapper".

    ![IntelliJ 14 CE -- Gradle import dialog](img/setup/java/mac-osx--idea-ce-gradle-import-dialog.png)

5. Click "OK".  IntelliJ will automatically create its project artifacts based on the Gradle project file.

 * After the project has loaded and you've dismissed the "Tip of the Day" dialog, you may see a
   notice (in the top-right-hand corner), saying, "Unindex remote maven repositories found." you can
   safely dismiss this notice.

6. Open the `README.md` file and carefully read the background for the assignment.

7. Start by running the test suite: In the "Project" view, right-click on the test file
   (`etl\src\test\java\EtlTest`), select "Run", then pick the "EtlTest" that has a JUnit icon to the
   left of it (red and green arrows), NOT the Gradle icon (circular green).
   ![Run tests through IDEA JUnit Runner, NOT Gradle](img/setup/java/mac-osx--idea-ce-run-unit-tests.png)

 * If these menu options don't appear at first, wait for a few seconds and try again; IntelliJ is still
   configuring the project with a Java nature.

 * When you first start an exercise, you should expect compilation errors because the test is
   setting expectations on a class that you need to write.  By trying to run the tests, you get a
   nice list of what needs to be fixed in the "Messages Make" view.

... and away you go!!!
