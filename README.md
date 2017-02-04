# xJava [![Build Status](https://travis-ci.org/exercism/xjava.svg?branch=master)](https://travis-ci.org/exercism/xjava) [![Join the chat at https://gitter.im/exercism/xjava](https://badges.gitter.im/exercism/xjava.svg)](https://gitter.im/exercism/xjava?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Source for Exercism Exercises in Java.

## Contributing Guide

For general information about how to contribute to Exercism, please refer to the [Contributing Guide](https://github.com/exercism/x-api/blob/master/CONTRIBUTING.md#the-exercise-data).

## Table of Contents

* [Overview](#overview)
* [Contributing With Minimal Setup](#contributing-with-minimal-setup)
* [Getting Familiar With the Codebase](#getting-familiar-with-the-codebase)
  * [The `exercises` Module](#the-exercises-module)
  * [The Problem Submodules](#the-problem-submodules)
* [Advanced: Complete Local Setup](#advanced-complete-local-setup)
  * [Tip: `gradle clean` before `exercism fetch`](#tip-gradle-clean-before-exercism-fetch)


## Overview

This guide covers contributing to the Java track.  If you are new, this guide is for you.

If, at any point, you're having any trouble, pop in the [Gitter exercism/dev room](https://gitter.im/exercism/dev) for help.

## Contributing With Minimal Setup

First things first: by contributing to Exercism, you are making this learning tool that much better and improving our industry as a whole... thank you!!!

To submit a fix for an existing exercise or port an exercise to Java with the least amount of setup:

1. **Ensure you have the basic Java tooling installed:**  JDK 1.8+, an editor and Gradle 2.x.

   (see [exercism.io: Installing Java](http://exercism.io/languages/java/installing))
-  **Setup a branch on a fork of [exercism/xjava](https://github.com/exercism/xjava) on your computer.**

   See [GitHub Help: Forking](https://help.github.com/articles/fork-a-repo/).  Use those instructions (in conjunction with [Exercism Contributing Guide](https://github.com/exercism/x-common/blob/master/CONTRIBUTING.md#git-basics)) to:
   * "fork" a repository on GitHub;
   - install `git`;
   - "clone" a copy of your fork;
   - configure an "upstream remote" (in this case, `exercism/xjava`);
   - create a branch to house your work
-  **Write the codes.**  Do your work on that branch you just created.

   The [Getting Familiar With the Codebase](#getting-familiar-with-the-codebase) section, below, is an orientation.
-  **Commit, push and create a pull request.**

   Something like:
   ```
   $ git add .
   $ git commit -m "(An intention-revealing commit message)"
   $ git push
   ```

   [Exercism Contributing Guide :: Commit Messages](https://github.com/exercism/x-common/blob/master/CONTRIBUTING.md#commit-messages) provides practical advice on crafting meaningful commit messages.
-  **Verify that your work passes all tests.**  When you create a pull request (PR), GitHub triggers a build on Travis CI.  Your PR will not be merged unless those tests pass.

## Getting Familiar With the Codebase

There are two objectives to the design of this build:

1. when a problem is built from within the xjava repo, the tests run against the "example" code (i.e. when you, the contributor, are developing the exercise);
2. when a problem is built outside the xjava repo (when a participant is solving the exercise), the tests run against the "main" code.

This repo is a multi-project gradle build.

### The `exercises` Module

This is the top-level module, contained in the `exercises` directory.  It is a container for the problem sub-modules.

  * it's `build.gradle` points the "main" sourceset to the example code.
  * it's `settings.gradle` names each of the subprojects, one for each problem in the set.

### The Problem Submodules

The `exercises` subdirectory contains all of the problem submodules.
Each problem/submodule is a subdirectory of the same name as its slug.

  * it's `build.gradle` names dependencies required to work that problem.

Each problem/submodule has three source sets:

* `src/test/java/` — a test suite defining the edges of the problem
* `src/example/java/` — an example solution that passes all the tests
* `src/main/java/` — starter source files, if required/desired *(this directory usually only has a `.keep` file in it)*.

----

## Advanced: Complete Local Setup

If you are going to make significant contribution(s) to the track, you might find it handy to have a complete local install of exercism on your computer.  This way, you can run the full suite of tests without having to create/update a PR.

The easiest way to achieve this is simply use the `bin/journey-test.sh` script.  However, you may want to perform other tests, depending on what you are doing.  You can do so by duplicating the setup performed by the `bin/journey-test.sh` script.

### Tip: `gradle clean` before `exercism fetch`

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

This is because some files generated by the build can't be served from the x-api.  This is by design: the CLI does not serve binaries.  To fix this, simply make sure you do a clean in your `xjava` repo before you fetch:

```
cd ~/workspace/exercism/xjava/exercises
gradle clean
cd ~/workspace/exercism/exercises
exercism fetch java bob
```


# License

The MIT License (MIT)

Copyright (c) 2014 Katrina Owen, _@kytrinyx.com
