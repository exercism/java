# Installing Java

In addition to the exercism CLI and your favorite text editor, practicing with Exercism exercises in Java requires:

* the **Java Development Kit** (JDK) — which includes both a Java Runtime *and* development tools (most notably, the Java compiler); and
* **Gradle** — a build tool specifically for Java projects.

Choose your operating system:

* [Windows](#windows)
* [Mac OS X](#mac-os-x)
* [Linux](#linux)

... or ...
* if you prefer to not use a package maanger, you can [install manually](#install-manually).

Optionally, you can also use a [Java IDE](#java-ides).

----

# Windows

Open an administrative command prompt.  (If you need assistance opening an administrative prompt, see [open an elevated prompt in Windows 8+](http://www.howtogeek.com/194041/how-to-open-the-command-prompt-as-administrator-in-windows-8.1/) (or [Windows 7](http://www.howtogeek.com/howto/windows-vista/run-a-command-as-administrator-from-the-windows-vista-run-box/)).

1. If you have not installed Chocolatey, do so now:

   ```batchfile
   C:\Windows\system32> @powershell -NoProfile -ExecutionPolicy unrestricted -Command "iex ((new-object net.webclient).DownloadString('https://chocolatey.org/install.ps1'))" && SET PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin
   ```
2.  Install the JDK:

   ```batchfile
   C:\Windows\system32> choco install jdk8
   ...
   C:\Windows\system32> refreshenv
   ...
   ```
3.  Install Gradle:

   ```batchfile
   C:\Windows\system32>choco install gradle
   ...
   ```

We recommend closing the administrative command prompt and opening a new command prompt -- you do not require administrator priviledges to practice Exercism exercises.

You now are ready to get started with the Java track of Exercism!

To get started, see "[Running the Tests](http://exercism.io/languages/java/tests)".

----

# Mac OS X

Below are instructions for install using the most common method - using Homebrew.  If you'd rather, you can also [install on OS X without Homebrew](#installing-on-mac-os-x-without-homebrew).

## Installing

1. If you haven't installed [Homebrew](http://brew.sh), yet, do so now:

   ```sh
   $ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
   ```
2. Tap the [Homebrew Cask](https://caskroom.github.io/) — this allows us to install pre-built binaries like the JDK.

   ```
   $ brew tap caskroom/cask
   ```
3.  Install the JDK:

   ```
   $ brew cask install java
   ```
4.  Install Gradle:

   ```
   $ brew install gradle
   ```

You now are ready to get started with the Java track of Exercism!

To get started, see "[Running the Tests](http://exercism.io/languages/java/tests)".

----

# Linux

Below are instructions for install using the package manager of your distro.  If you'd rather, you can also [install on Linux without a package manager](#installing-on-linux-without-a-package-manager).

* [Debian](#debian)
* [Fedora](#fedora)

## Debian

If you are using Debian or its derivatives (like Ubuntu or Linux Mint), use APT:

*(verified on: Linux Mint 18, Ubuntu 14)*

1. Install the JDK:

   ```sh
   $ sudo apt-get update
   $ sudo apt-get install python-software-properties
   $ sudo add-apt-repository ppa:webupd8team/java
   $ sudo apt-get update
   $ sudo apt-get install oracle-java8-installer
   $ sudo apt install oracle-java8-set-default
   ```
2. Install Gradle:

   ```sh
   $ sudo add-apt-repository ppa:cwchien/gradle
   $ sudo apt-get update
   $ sudo apt-get install gradle
   ```

You now are ready to get started with the Java track of Exercism!

To get started, see "[Running the Tests](http://exercism.io/languages/java/tests)".

----

## Fedora

If you are using Fedora or its derivatives, use DNF:

*(verified on: Fedora 24)*

1. Install the JDK:

   ```sh
   $ sudo dnf install java-1.8.0-openjdk-devel
   ```
2. Install Gradle:

   ```sh
   $ sudo dnf install gradle
   ```


You now are ready to get started with the Java track of Exercism!

To get started, see "[Running the Tests](http://exercism.io/languages/java/tests)".

----

# Install Manually

* [Installing on Windows manually](#installing-on-windows-manually)
* [Installing on Mac OS X without Homebrew](#installing-on-mac-os-x-without-homebrew)
* [Installing on Linux without a package manager](#installing-on-linux-without-a-package-manager)

----

## Installing on Windows manually

*NOTE: these instructions are intended for experienced Windows users.  If you don't already know how to set environment variables or feel comfortable managing the directory structure, we highly recommend you use the Chocolatey-based install, [above](#windows).*

1. Install the JDK:
   1. Download "**Java Platform (JDK)**" from [Oracle OTN](http://www.oracle.com/technetwork/java/javase/downloads/index.html).
   -  Run the installer, using all the defaults.
2. Install Gradle:
   - Download "**Binary only distribution**" from the [Gradle download page](https://gradle.org/gradle-download/).
   - Unzip the archive.  We recommend a place like `C:\Users\JohnDoe\Tools`.
   - Add a new system environment variable named `GRADLE_HOME` and set it to the path you just created (e.g. `C:\Users\JohnDoe\Tools\gradle-x.y`).
   - Update the system `Path` to include the `bin` directory from Gradle's home (e.g. `Path`=`...;%GRADLE_HOME%\bin`).


You now are ready to get started with the Java track of Exercism!

To get started, see "[Running the Tests](http://exercism.io/languages/java/tests)".

----

## Installing on Mac OS X without Homebrew

*NOTE: these instructions are intended for experienced Mac OS X users.  Unless you specifically do not want to use a package manager, we highly recommend using the Homebrew-based installation instructions, [above](#mac-os-x).*

1. Install the JDK:
   1. Download "**Java Platform (JDK)**" from [Oracle OTN](http://www.oracle.com/technetwork/java/javase/downloads/index.html).
   2. Run the installer, using all the defaults.
2. Install Gradle:
   1. Download "**Binary only distribution**" from the [Gradle download page](https://gradle.org/gradle-download/).
   2. Unpack Gradle:

      ```sh
      $ mkdir ~/tools
      $ cd ~/tools
      $ unzip ~/Downloads/gradle-*-bin.zip
      $ cd gradle*
      ```
   3. Configure Gradle and add it to the path:

      ```sh
      $ cat << DONE >> ~/.bashrc
      export GRADLE_HOME=`pwd`
      export PATH=\$PATH:\$GRADLE_HOME/bin
     DONE
     ```


You now are ready to get started with the Java track of Exercism!

To get started, see "[Running the Tests](http://exercism.io/languages/java/tests)".

----

## Installing on Linux without a package manager

*NOTE: these instructions are intended for experienced Linux users.  Unless you specifically do not want to use a package manager, we highly recommend using the the installation instructions, [above](#linux).*

1. Install the JDK:
   1. Download "**Java Platform (JDK)**" from [Oracle OTN](http://www.oracle.com/technetwork/java/javase/downloads/index.html).
   2. Run the installer, using all the defaults.
2. Install Gradle:
   1. Download "**Binary only distribution**" from the [Gradle download page](https://gradle.org/gradle-download/).
   2. Unpack Gradle:

      ```sh
      $ mkdir ~/tools
      $ cd ~/tools
      $ unzip ~/Downloads/gradle-*-bin.zip
      $ cd gradle*
      ```
   3. Configure Gradle and add it to the path:

      ```sh
      $ cat << DONE >> ~/.bashrc
      export GRADLE_HOME=`pwd`
      export PATH=\$PATH:\$GRADLE_HOME/bin
     DONE
     ```

You now are ready to get started with the Java track of Exercism!

To get started, see "[Running the Tests](http://exercism.io/languages/java/tests)".

----

# Java IDEs

There are many Java IDEs available.  The three most popular are:

* [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) (download the "Community" edition)
- [Eclipse](https://www.eclipse.org/downloads/)
- [NetBeans](https://netbeans.org/downloads/) (download the "Java SE" bundle)

and there are [others](https://en.wikibooks.org/wiki/Java_Programming/Java_IDEs).

