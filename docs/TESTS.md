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

## Windows with Netbeans

This could also apply, with slight variations, to all OSs that support the Netbeans IDE (currently available for Windows, Mac OS X, and Linux). When downloading Netbeans, be sure to get the Java SE, Java EE, or "All" version. You may also need a JDK.

### Getting started 

In the terminal window, get the exercise
        
```
C:\Users\johndoe> exercism fetch java

New:
java (Etl)      C:\Users\johndoe\exercism\java\etl

unchanged: 0, updated: 0, new: 1
```
 
### Importing the Project in to Netbeans  
  
1. In Netbeans, open a new project: File > New Project
2. Select "Java" from the Categories window on the left, then "Java Proejct with Existing Sources" from the Projects window on the right. Click Next.
3. Type in a project name and use the default Project Folder and Build Script Name settings. Click Next.
4. Now you will choose your source folders. Under the Source Package Folders window on the top, click "Add Folder..."
5. Navigate to the folder where exercism created your project and select the "java" folder under "main". For example, `C:\Users\johndoe\exercism\java\etl\src\main\java`
6. Now do the same for the Test Package Folders window on the bottom, but choose the "java" folder under "test". For example, `C:\Users\johndoe\exercism\java\etl\src\test\java`
8. Click Next and accept the defaults on the next screen (Includes and Excludes)
9. Click Finish

If you see a warning about resolving project problems, right-click on the project and click "Resolve Project Problems..." and let Netbeans automatically handle this. This is due to the fact the JUnit 4.12 does not bundle the hamcrest matchers library.

### Running the Tests
To run the tests, simply right-click on the test file under the Test Packages folder, and click *Run File* or *Debug File*. The test results will appear in a window on the bottom - green for pass, red for fail.

Good luck!


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

    ![IntelliJ 14 CE -- Gradle import dialog](http://x.exercism.io/v3/tracks/java/docs/img/mac-osx--idea-ce-gradle-import-dialog.png)

5. Click "OK".  IntelliJ will automatically create its project artifacts based on the Gradle project file.

 * After the project has loaded and you've dismissed the "Tip of the Day" dialog, you may see a
   notice (in the top-right-hand corner), saying, "Unindex remote maven repositories found." you can
   safely dismiss this notice.

6. Open the `README.md` file and carefully read the background for the assignment.

7. Start by running the test suite: In the "Project" view, right-click on the test file
   (`etl\src\test\java\EtlTest`), select "Run", then pick the "EtlTest" that has a JUnit icon to the
   left of it (red and green arrows), NOT the Gradle icon (circular green).
   ![Run tests through IDEA JUnit Runner, NOT Gradle](http://x.exercism.io/v3/tracks/java/docs/img/mac-osx--idea-ce-run-unit-tests.png)

 * If these menu options don't appear at first, wait for a few seconds and try again; IntelliJ is still
   configuring the project with a Java nature.

 * When you first start an exercise, you should expect compilation errors because the test is
   setting expectations on a class that you need to write.  By trying to run the tests, you get a
   nice list of what needs to be fixed in the "Messages Make" view.

... and away you go!!!
