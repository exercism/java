# Installing Java

* [Getting Started Fast](#getting-started-fast)
  * [On Windows](#on-windows)
  - [On OS X](#on-os-x)
* [Command-Line Development Setup](#command-line-development-setup)
* [Java IDEs](#java-ides)

----
# Getting Started Fast

*NOTE: If you prefer using the command-line for development, skip down to [Command-Line Development Setup](#command-line-development-setup)*.

*NOTE: For simplicity's sake, we provide step-by-step instructions for a particular Java IDE: JetBrain's IntelliJ IDEA.  If you actually have a preference, feel free to use any IDE of your choice.  We have included an outline for setting up other IDEs, in the [Java IDEs](#java-ides) section, below.*

There are two flavors of these instructions:

* [On Windows](#on-windows)
* [On OS X](#on-os-x)

## On Windows

* [Step 1 — Ensure JDK 8 is installed](#step-1--ensure-jdk-8-is-installed)
* [Step 2 — Install IntelliJ IDEA (Community Edition)](#step-2--install-intellij-idea-community-edition)

### Step 1 — Ensure JDK 8 is installed

First, determine if the JDK 8 is installed on your computer.

In a Command Prompt window (Start -> Command Prompt)...

```
C:\Users\johndoe> java -version
```

If you see...

```
'java' is not recognized as an internal or external command,
operable program or batch file.
```

... or if you see a version number less than 1.8 ...

```bash
java version "1.6.0_65"
Java(TM) SE Runtime Environment (build 1.6.0_65-b14-462-11M4609)
Java HotSpot(TM) 64-Bit Server VM (build 20.65-b04-462, mixed mode)
```

then you need to [install JDK 8](#installing-jdk-8-on-windows)

HOWEVER, if you see something like this *(the exact version number is not important, just that it is 1.8 or later)*.

```bash
java version "1.8.0_45"
Java(TM) SE Runtime Environment (build 1.8.0_45-b15)
Java HotSpot(TM) 64-Bit Server VM (build 25.45-b02, mixed mode)
```

... then you *already have* the latest version of Java installed, you can skip to [installing IntelliJ](#step-2--install-intellij-idea-community-edition).

#### Installing JDK 8 on Windows

1. Go to [Oracle OTN](http://www.oracle.com/technetwork/java/javase/downloads/index.html) and select the "**Java Platform (JDK)**" download.
-  At the top of the list of downloads, select "**Accept License Agreement**".
-  Select the "**Window x86**" download (unless you know for certain you're using 64-bit Windows, then feel free to grab the "Windows x64" version).
-  Run the installer, using all the defaults.

### Step 2 — Install IntelliJ IDEA (Community Edition)

#### Download and Install IntelliJ

1. Download [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/).
-  Run the installer; accept all the defaults.

#### Configure IntelliJ to Use JDK 8

1. Run IntelliJ (**Start** -> **All Programs** -> **JetBrains** -> **IntelliJ IDEA Community Edition**).
    * The first time you do, IntelliJ walks you through some initial setup.  We recommend selecting a UI Theme and then just clicking "Skip All and Set Defaults".
- In the "Welcome to IntelliJ IDEA" window, open the "**Configure**" pull-down and select "**Project Defaults**", then "**Project Structure**".
- In the "Default Project Structure" dialog, find the "Project SDK:" section in the right panel.  Click the "**New...**" button and select "**JDK**".
- In the "Select Home Directory for JDK" file open dialog, verify that path is set to "`C:\Program Files\Java\jdk1.8...`".  **Be sure to select the JDK, not the JRE.**  Click "**OK**".
- Click "**OK**" again to get back to the "Welcome to IntelliJ IDEA" window.

You now are ready to get started with the Java track of Exercism!

For help with working on an exercise in IntelliJ, click on "[Running the Tests](http://exercism.io/languages/java/tests)".

----

## On OS X

* [Step 1 — Ensure JDK 8 is installed](#step-1--ensure-jdk-8-is-installed-1)
* [Step 2 — Install IntelliJ IDEA (Community Edition)](#step-2--install-intellij-idea-community-edition-1)

### Step 1 — Ensure JDK 8 is installed

First, determine if the JDK 8 is installed on your computer.

In a Terminal window (launch the "Terminal" app)...

```bash
$ java -version
```

If you see...

![To use the "java," command-line tool you need to install a JDK.  Click "More Info..." to visit the Java Developer Kit download website.](http://x.exercism.io/v3/tracks/java/docs/img/mac-osx--install-java-dialog.png)

... or if you see a version number less than 1.8 ...

```bash
java version "1.6.0_65"
Java(TM) SE Runtime Environment (build 1.6.0_65-b14-462-11M4609)
Java HotSpot(TM) 64-Bit Server VM (build 20.65-b04-462, mixed mode)
```

then you need to [install JDK 8](#installing-jdk-8-on-os-x).

HOWEVER, if you see something like this *(the exact version number is not important, just that it is 1.8 or later)*.

```bash
java version "1.8.0_45"
Java(TM) SE Runtime Environment (build 1.8.0_45-b15)
Java HotSpot(TM) 64-Bit Server VM (build 25.45-b02, mixed mode)
```

... then you *already have* the latest version of Java installed, you can skip to [installing IntelliJ](#step-2--install-intellij-idea-community-edition-1)

#### Installing JDK 8 on OS X

1. Either click the "More info..." button -or- go to [Oracle OTN](http://www.oracle.com/technetwork/java/javase/downloads/index.html) and select the "**Java Platform (JDK)**" download.
-  Find the latest version of the "Java SE Development Kit".
-  At the top of the list of downloads, select "**Accept License Agreement**".
-  select the "**Mac OS X**" download.
-  Run the installer, using all the defaults.

### Step 2 — Install IntelliJ IDEA (Community Edition)

#### Download and Install IntelliJ

1. Download [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/).
-  Run the installer; accept all the defaults.

#### Configure IntelliJ to Use JDK 8

1. Launch IntelliJ (in the Dock, click on Launchpad and find "IntelliJ IDEA CE")
    * The first time you do, IntelliJ walks you through some initial setup.  We recommend selecting a UI Theme and then just clicking "Skip All and Set Defaults".
- In the "Welcome to IntelliJ IDEA" window, open the "**Configure**" pull-down and select "**Project Defaults**", then "**Project Structure**".
- In the "Default Project Structure" dialog, find the "Project SDK:" section in the right panel.  Click the "**New...**" button and select "**JDK**".
- In the "Select Home Directory for JDK" file open dialog, verify that the path is: `/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home`. Click "**OK**".
- Click "**OK**" again to get back to the "Welcome to IntelliJ IDEA" window.

You now are ready to get started with the Java track of Exercism!

For help with working on an exercise in IntelliJ, click on "[Running the Tests](http://exercism.io/languages/java/tests)".

----

# Command-Line Development Setup

Developing Java on the command-line requires:

* the Java Development Kit (JDK) — which includes both a Java Runtime *and* development tools (most notably, the Java compiler).
* a text editor — presumably, if you are comfortable with the command-line, you have a favorite text editor; use that.
* Gradle — a Java-oriented make and dependency management tool.  While technically optional, using a build tool like Gradle makes it significantly easier to compile your Java code, download any needed libraries (and included them in your compilation and execution classpath), and execute the tests for each exercise.

We'll manage this install using Homebrew, a popular OS X package manager.

## Installing

1. Ensure [Homebrew](http://brew.sh/) is installed.
-  Tap the [Homebrew Cask](https://caskroom.github.io/) — this allows us to install pre-built binaries like the JDK.
-  Install the JDK:

   ```
   $ brew cask install java
   ```
-  Install Gradle:

   ```
   $ brew install gradle
   ```

*Tip: this [Stackoverflow answer](https://stackoverflow.com/questions/26252591/mac-os-x-and-multiple-java-versions/29195815#29195815) provides an in-depth treatment of managing Java versions on OS X.*

You now are ready to get started with the Java track of Exercism!

For help with working on an exercise in IntelliJ, click on "[Running the Tests](http://exercism.io/languages/java/tests)".

----

# Java IDEs

There are many Java IDEs available.  The three most popular are:

* Eclipse (from IBM)
- NetBeans (from Oracle)
- IntelliJ IDEA (from JetBrains)

and there are [others](https://en.wikibooks.org/wiki/Java_Programming/Java_IDEs).

## Installing Eclipse

1. Install the JDK, as described above ([Windows](#step-1--ensure-jdk-8-is-installed) or [OS X](#step-1--ensure-jdk-8-is-installed-1)).
-  Download and install Eclipse from the [download page](https://eclipse.org/downloads/).
-  Install the [Gradle Eclipse plugin](http://www.vogella.com/tutorials/EclipseGradle/article.html).

## Installing NetBeans

Unlike other IDEs, NetBeans comes bundled *with* the JDK.

1. Download and install NetBeans (and the JDK) from the [Oracle OTN](http://www.oracle.com/technetwork/java/javase/downloads/index.html).
-  Install and configure the [Gradle NetBeans plugin](http://plugins.netbeans.org/plugin/44510/gradle-support).


