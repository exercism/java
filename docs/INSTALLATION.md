## Installation

You will need:

* Java 8
* Gradle

### Java

If typing `java -version` on the command-line returns `command not found` or similar, then go to [java.com](https://www.java.com/en/download/help/index_installing.xml), which will tell you how to install Java on your system.

If Java is already installed, you will see something like the following, perhaps with some extra details about builds and virtual machines:

    java version "1.8.0"

### Gradle

On Mac OS X you can install Gradle using homebrew:

    brew install gradle

On Windows you will need to visit the [Gradle](http://gradle.org/installation) website and follow the instructions there.

* Download the latest version (big green button)
* Unpack the ZIP file, which will contain a folder (e.g. gradle-2.2.1)
* Copy the folder to a convenient location
* Add that location + `\bin` to your `PATH`

Verify that it has been installed correctly by running:

    gradle -version

You should see a version number as well as some extra information about build time and dependencies.
