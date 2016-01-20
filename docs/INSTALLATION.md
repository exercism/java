## Windows

If you are new-ish to programming in Java, these instructions are for you. This is a step-by-step opinionated guide to getting from zero to submitting your first exercise.


### Install Java Development Kit 1.8


First determine if you have Java installed already.

In a Command Prompt window (Start -> Command Prompt)...

```
C:\Users\johndoe> java -version
```

if you see:

```
'java' is not recognized as an internal or external command,
operable program or batch file.
```

You'll need to install the JDK — it contains both a Java Runtime and development tools.

1. Go to [Oracle OTN](http://www.oracle.com/technetwork/java/javase/downloads/index.html) and download the latest version of the JDK (at the time of writing, [JDK 8u45](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
2. Run the installer, using all the defaults.

Verify that the install worked.

Close any open Command Prompt windows and in a *new* Command Prompt window...

```
C:\Users\johndoe> java -version
```

You should see something like this:

```
java version "1.8.0_45"
Java(TM) SE Runtime Environment (build 1.8.0_45-b15)
Java HotSpot(TM) 64-Bit Server VM (build 25.45-b02, mixed mode)
```

The exact version number is not important, just that version 1.8 or better is installed. Circa 2004, Sun Microsystem, in their inifinite wisdom, decided that it would be "better" to have dual numbering conventions.  Java 1.8 == Java 8.0.

### Install IntelliJ IDEA Community Edition

Download, install and configure IntelliJ with the JDK you have installed:

1. Download [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/) and run the installer; accept all the defaults.

2. Run IntelliJ (Start -> All Programs -> JetBrains -> IntelliJ IDEA Community Edition).
    * The first time you do, IntelliJ walks you through some initial setup.  We recommend selecting a UI Theme and then just clicking "Skip All and Set Defaults".

3. In the "Welcome to IntelliJ IDEA" window, open the "Configure" pull-down and select "Project Defaults", then "Project Structure".

3. In the "Default Project Structure" dialog, find the "Project SDK:" section in the right panel.  Click the "New..." button and select "JDK".

4. In the "Select Home Directory for JDK" file open dialog, navigate to "`C:\Program Files\Java\jdk1.8...`".  Be sure to select the JDK, not the JRE.  Click "OK".

5. Back in the "Default Project Structure" dialog, in the "Project language level:" section, select "8 - Lambdas, type annotations etc.".  Click "OK".

## Mac OS X

If you are new-ish to programming in Java on Mac OS X, these instructions are for you.
This is a step-by-step opinionated guide to getting from zero to submitting your first exercise.

### Step 1 — Install Java Development Kit 1.8

First, determine if the JDK 1.8 is installed:

```bash
$ java -version
```

What you do next depends on the output of that command.

#### No JDKs Installed

If you have no JDKs installed at all (e.g. you have a fresh install of Mac OS X 10.10 [Yosemite]),
the OS presents a dialog:

![To use the "java," command-line tool you need to install a JDK.  Click "More Info..." to visit the Java Developer Kit download website.](http://x.exercism.io/v3/tracks/java/docs/img/mac-osx--install-java-dialog.png)

Clicking on the "More Info..." button takes you to the [Oracle OTN](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

Download the latest version of the JDK (at the time of writing,
[JDK 8u71](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
and run the installer, using all the defaults.

Skip down to [Verify JDK Install](#verify-jdk-install)

#### Older JDKs Installed

If you see something like...

```bash
java version "1.6.0_65"
Java(TM) SE Runtime Environment (build 1.6.0_65-b14-462-11M4609)
Java HotSpot(TM) 64-Bit Server VM (build 20.65-b04-462, mixed mode)
```

Or any version that is prior to 1.8, you need to install the 1.8 JDK...

1. Go to [Oracle OTN](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
and download the latest version of the JDK (at the time of writing,
[JDK 8u71](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
2. Run the installer, using all the defaults.

#### Verify JDK Install

Let's verify that the installation worked...

```bash
$ java -version
```

You should see something like this:

```bash
java version "1.8.0_45"
Java(TM) SE Runtime Environment (build 1.8.0_45-b15)
Java HotSpot(TM) 64-Bit Server VM (build 25.45-b02, mixed mode)
```

The exact version number is not important, just that version 1.8 or better is installed.
Circa 2004, Sun Microsystem, in their inifinite wisdom, decided that it would be "better" to
have dual numbering conventions.  Java 1.8 == Java 8.0.

Congratulations, you've ensured you have the proper version of Java, itself, installed!

### Step 2 — Install IntelliJ IDEA Community Edition

Download, install and configure IntelliJ with the JDK you have installed:

1. Download [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/) and
run the installer; accept all the defaults.

2. Run IntelliJ (`/Applications/IntelliJ IDEA 14 CE.app`)
    * The first time you do, IntelliJ walks you through some initial setup.  We recommend
      selecting a UI Theme and then just clicking "Skip All and Set Defaults".

3. In the "Welcome to IntelliJ IDEA" window, open the "Configure" pull-down and select
   "Project Defaults", then "Project Structure".

6. In the "Default Project Structure" dialog, find the "Project SDK:" section in the right panel.
   Click the "New..." button and select "JDK".

5. In the "Select Home Directory for JDK" file open dialog, navigate to
   `/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home`. Click "OK".

6. Back in the "Default Project Structure" dialog, in the "Project language level:" section,
   select "8 - Lambdas, type annotations etc.".  Click "OK".
