# xJava [![Build Status](https://travis-ci.org/exercism/xjava.svg?branch=master)](https://travis-ci.org/exercism/xjava)

Exercism Exercises in Java.

## Contributing Guide

For general information about how to contribute to Exercism, please refer to the [Contributing Guide](https://github.com/exercism/x-api/blob/master/CONTRIBUTING.md#the-exercise-data).

## Table of Contents

* [Overview](#overview)
* [Getting Setup](#getting-setup)
* [Getting Familiar With the Codebase](#getting-familiar-with-the-codebase)
  * [The Rootproject](#the-rootproject)
  * [The Problem Subprojects](#the-problem-subprojects)
  * [Running The Build](#running-the-build)
* [Submitting Your Contribution](#submitting-your-contribution)
  * [Doing the Commit Dance](#doing-the-commit-dance)
  * [Making the Pull Request](#making-the-pull-request)
* [Reverting Your CLI Config](#reverting-your-cli-config)


## Overview

This guide walks you through how to contribute to the Java language track.  It is opinionated and specific to allow those who are relatively new to Free Open Source Software to have a fighting chance of being successful.  However, if you know what you're doing, we intent these instructions to be guidelines.

The steps described herein were composed on OS X.  They will presumably work with no change on any *nix distro.  Almost all of them will work on Windows; though you might want to use cygwin or some other Unix support for creating soft-links.  Otherwise, you'll need to improvise on some steps.  If you *do* find a nice workflow for Windows, please feel free to submit a PR for changes to this doc.  Thanks!

This guide flows chronologically, from setting-up your environment, taking a quick tour of the build process to finally what it takes to successfully submit.

If, at any point, you're having any trouble, pop in the [Gitter exercism/dev room](https://gitter.im/exercism/dev) for help.


## Getting Setup

You'll *need* the following:

* Java 1.8+
* Gradle 2.x
* Ruby 1.9+  (to run the [x-api](https://github.com/exercism/x-api)).
* Git 1.x

If you haven't already, please read our advice on [Git Workflow](http://help.exercism.io/git-workflow.html).


Here's one way to get setup:

1. **Stand-up the x-api, locally.**  You should ultimate verify your work by delivering your problem through the exercism CLI and solving it from that `exercism fetch`'ed copy.  The CLI fetches problems from the x-api.  You'll need your own instance of the x-api running locally.

	```
	cd ~
	mkdir -p workspace/exercism && cd workspace/exercism
	git clone https://github.com/exercism/x-api
	cd x-api
	bundle install
	git submodule init
	git submodule update
	rackup
	```

If you want more details, check out the [x-api README](https://github.com/exercism/x-api).

2. **Configure your exercism CLI to point to that x-api.** Out of the box, the CLI is configured to point to the production instances of the API (for account-specific data) and X-API (for problem data).  You need to configure your CLI to point to the X-API instance you stood up in the prior step.
	
	If you haven't already, you'll need need to [install the CLI](http://help.exercism.io/installing-the-cli.html).

	```
	cd ~
	mkdir -p workspace/exercism/exercises
	cd ~/workspace/exercism/exercises
	exercism configure --dir=~/workspace/exercism/exercises
	exercism configure --api http://localhost:9292
	exercism debug
	exercism fetch java bob
	tree java
	```

	If things are properly setup:
	* `exercism debug` output will include "`XAPI: http://localhost:9292 [connected]`"
	* `tree java` will look something like this:
	
		```
		java
		└── bob
		    ├── README.md
		    ├── build.gradle
		    └── src
		        └── test
		            └── java
		                └── BobTest.java
		```

3. **Point your local x-api to your xjava fork.**  Most people contribute by submitting pull request from their fork of the track repo (covered below).  To make it easy to develop, replace the java problem set in your local x-api with your fork:

	If you haven't already, fork the track repo: [exercism/xjava](https://github.com/exercism/xjava).

	```
	cd ~/workspace/exercism/
	git clone git@github.com:jtigger/xjava.git
	git remote add upstream https://github.com/exercism/xjava.git
	git pull --rebase upstream/master
	cd ~/workspace/exercism/x-api/problems
	rm -rf java
	ln -s ../../xjava java
	```

You are now ready to go!

## Getting Familiar With the Codebase

There are two objectives to the design of this build:

1. when a problem is built from within the xjava repo, the tests run against the "example" code.
2. when a problem is built outside the xjava repo (namely, when it has been served through the CLI on a user's computer), the tests run against the "main" code.

This repo is a mulit-project gradle build.

### The Rootproject

The rootproject is a container for the problem subprojects.

  * it's `build.gradle` points the "main" sourceset to the example code.
  * it's `settings.gradle` names each of the subprojects, one for each problem in the set.


### The Problem Subprojects

Each problem/subproject is a subdirectory of the same name as its slug.

  * it's `build.gradle` names dependencies required to work that problem.

Each problem/subproject has three source sets:

* `src/test/java/` — a test suite defining the edges of the problem
* `src/example/java/` — an example solution that passes all the tests
* `src/main/java/` — starter source files, if required/desired *(this directory usually only has a `.keep` file in it)*.

### Running The Build

To run all the tests against example code:

```
cd ~/workspace/exercism/xjava
gradle assemble check
```

To run the test against just one problem, run gradle from within that directory:

```
cd ~/workspace/exercism/xjava/bob
gradle assemble check
```

To run the complete build as done on CI (which includes compiling any "starter" code and running the configlet tool):

```
cd ~/workspace/exercism/xjava
./bin/build.sh
```

## Developing

### Tip: gradle clean before exercism fetch

If you `exercism fetch` after doing a build, the CLI will fail with the following error message:

```
$ exercism fetch java bob
2015/09/06 15:03:21 an internal server error was received.
Please file a bug report with the contents of 'exercism debug' at: https://github.com/exercism/exercism.io/issues 
```

and if you review the logs of your x-api, you'll find:

```
127.0.0.1 - - [06/Sep/2015:15:20:56 -0700] "GET /v2/exercises/java/bob HTTP/1.1" 500 514949 0.2138
2015-09-06 15:21:01 - JSON::GeneratorError - source sequence is illegal/malformed utf-8:
```

This is because some files generated by the build can't be served from the x-api.  That's actually fine.  To fix this, simply make sure you do a clean in your xjava repo before you fetch:

```
cd ~/workspace/exercism/xjava
gradle clean
cd ~/worksapce/exercism/exercises
exercism fetch java bob
```

## Submitting Your Contribution

First of all... Exercism is meant help programmers, world-wide, to develop their skills and in doing so help raise the bar on our industry as a whole.  Your contribution is making that experience even better.  Thank you!

Before you submit a pull request, please ensure:

- the test suite covers the essential parts of the problem and interesting corner cases.
- your example solution represents your best attempt at exemplary code. 
- the build script (`./bin/build.sh`) compiles and tests your code successfully.


### Doing the Commit Dance
*(These instructions assume you setup your development environment using the instructions above.)*

1. **Run the build script, locally.**
 
   ```
   cd ~/workspace/exercism/xjava
   ./bin/build.sh
   ```

   verify that the script runs successfully.
   
2. **Fetch the problem from your local x-api, using the CLI.**

   ```
   cd ~/workspace/exercism/exercises
   exercism fetch java <problem-slug>
   ```
   
   verify that the fetched problem does *not* contain any files not needed for the problem.
   
3. **Run the tests against the example source.**

   ```
   cd ~/workspace/exercism/exercises/java/<problem-slug>
   cp ../../../xjava/<problem-slug>/src/example/java/* src/main/java
   gradle check
   ```

   verify that all tests pass.
   
If you've successfully navigated to this point, you're ready to make that pull request!

### Making the Pull Request

Hopefully you've read our [Git Workflow](http://help.exercism.io/git-workflow.html) and done your work on a clone of a fork of the exercism xjava repo.

After you've pushed your changes to your fork (best done on a branch, remember), it's a matter of going to GitHub and submitting a pull request.

When you do so, notice that it automatically kicks off a CI build on Travis.  This is an important step: **be sure to wait for the CI results to come back before you leave!**  Pull Requests that do no pass CI will not be merged in.

One of the track maintainers will review your PR as soon as we can.

If you need help, drop in on the [Gitter exercism/dev room](https://gitter.im/exercism/dev).


## Reverting Your CLI Config

In the setup, above, we configured the CLI client to point to your local x-api instance.  Presumably, you like to submit solutions, yourself.  To revert your CLI back to the the production x-api:

```
exercism configure --api http://x.exercism.io
```


# License

The MIT License (MIT)

Copyright (c) 2014 Katrina Owen, _@kytrinyx.com
