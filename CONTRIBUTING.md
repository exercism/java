# Contributing

## Table of Contents

<!-- TOC -->

- [Contributing](#contributing)
  - [Table of Contents](#table-of-contents)
  - [Overview](#overview)
  - [Before Making Your Pull Request](#before-making-your-pull-request)
  - [Steps to your next contribution](#steps-to-your-next-contribution)
    - [Install tooling](#install-tooling)
    - [Create a new branch for your work](#create-a-new-branch-for-your-work)
    - [Write some code](#write-some-code)
      - [Check whether the reference implementation passes the tests](#check-whether-the-reference-implementation-passes-the-tests)
      - [Check whether the reference implementation passes the Checkstyle validations](#check-whether-the-reference-implementation-passes-the-checkstyle-validations)
      - [Check whether the starter implementation is able to compile with the tests](#check-whether-the-starter-implementation-is-able-to-compile-with-the-tests)
    - [Open a Pull Request](#open-a-pull-request)
  - [Contributing using IntelliJ IDEA](#contributing-using-intellij-idea)
    - [Clone the repository](#clone-the-repository)
    - [Importing the Gradle project](#importing-the-gradle-project)
    - [Creating a new branch](#creating-a-new-branch)
    - [Testing your changes](#testing-your-changes)
    - [Committing your changes](#committing-your-changes)
  - [Getting Familiar With the Codebase](#getting-familiar-with-the-codebase)
    - [The `exercises` Module](#the-exercises-module)
    - [The Problem Submodules](#the-problem-submodules)
  - [Contributing to Concept Exercises](#contributing-to-concept-exercises)
  - [Contributing to Practice Exercises](#contributing-to-practice-exercises)

## Overview

This guide covers contributing to the Java track. If you are new to the Exercism Java track, this guide is for you.

If, at any point, you're having any trouble, pop in the [Exercism forum][forum] for help.

For general guidelines about contributing to Exercism see the [Exercism contributing guide][docs-building] and [Contributing via GitHub][docs-building-github].

## Before Making Your Pull Request

Hi! Thanks for contributing to the Exercism Java track!

Before opening your pull request, please review the [track policies](POLICIES.md) and make sure your changes comply with them all.
This helps us focus our review time on the more important aspects of your contributions.

Also, please only address one issue per pull request and reference the issue in your pull request.
This makes it easier for us to review it, and it means that if we request changes to the fix for one issue, it won't prevent to a fix for another issue being merged.

It's perfectly fine to have more than one pull request open at a time.
In that case it's important to keep the work for each pull request on a separate [branch][git-branching] to prevent unrelated commits being added to your pull request.
This is good practice to do always, even if you only have one pull request open.

One last thing to note before you get started.
When you fork the repository, and you want to [sync your fork][github-sync-fork], you can perform a [`git rebase`][git-rebase].
This is preferred over merging the changes because merging leads to a dirty commit history whereas performing a rebase adds in those changes without making extra commit messages.
However, this is only preferred, so don't worry about it too much.

## Steps to your next contribution

First things first: by contributing to Exercism, you are making this learning tool that much better and improving our industry as a whole, so thank you!

To submit a fix for an existing exercise or port an exercise to Java with the least amount of setup, follow these steps.

### Install tooling

Make sure you have the latest Java tooling installed on your computer, see [exercism.org: Installing Java][docs-java-installation].

Also make sure you have `git` installed on your computer.

### Create a new branch for your work

Create a fork of the [exercism/java][track-repo] repository in your GitHub account, see [GitHub Help: Forking][github-forking].

Clone the fork you created to your computer using `git`, and create a new branch from the `main` branch to start working on your contribution.

### Write some code

The [Getting Familiar With the Codebase](#getting-familiar-with-the-codebase) section will help you get familiar with the project.

After making changes to one or more exercises, make sure that they pass all validations. Run the following commands from the root of the exercise directory.

#### Check whether the reference implementation passes the tests

```sh
gradle test
```

#### Check whether the reference implementation passes the Checkstyle validations

```sh
gradle check
```

#### Check whether the starter implementation is able to compile with the tests

```sh
gradle compileStarterTestJava
```

### Open a Pull Request

When you finished your changes and checked that all validations have passed, it's time to commit and push them to your fork:

```sh
$ git add .
$ git commit -m "(An intention-revealing commit message)"
$ git push -u origin your-branch-name
```

Then, open a Pull Request on the [exercism/java][track-repo] repository.
Check out the [Contributors Pull Request Guide][docs-building-github-prs] for some guidelines on what we expect in a Pull Request.

After opening a Pull Request, one of our maintainers will try to review it as soon as they are available.
They will also trigger the GitHub Actions workflows which will build and test the project.
Your Pull Request will not be merged unless those workflows pass.

## Contributing using IntelliJ IDEA

IntelliJ IDEA is one of the more popular IDEs when working with Java, and it includes several tools to help simplify the process.
The following steps outline how to import the git repository, make changes, and push them back to your [fork][github-forking].

### Clone the repository

Open the IDE, and from the startup menu select "Check out from Version Control".
This will open a dialog where you can enter the URL of your fork repository and specify the directory that you would like to clone the repo into.

![Cloning a repository from IntelliJ IDEA](assets/clone-repo.png)

### Importing the Gradle project

Select "Import Project from External Model" and click the "Gradle" radio.

![Importing a Gradle project in IntelliJ IDEA](assets/gradle-import.png)

Set the Gradle properties per the screenshot below. Ensure that the "exercises" folder is selected as the root of the project

![Gradle properties to use when importing the project in IntelliJ IDEA](assets/gradle-setup.png)

**Add the `java` folder as a module**.
Open the project settings and view the modules.
Click the `+` button, select "Import Module".
Select the `java` directory and accept the default values.

![Importing a Gradle module in IntelliJ IDEA](assets/java-module.png)

### Creating a new branch

The git tools in IDEA are located in the VCS menu.
To create a new branch, select VCS > Git > Branches and then click "New Branch".
Give the branch a meaningful name and create.

![Git branches menu in IntelliJ IDEA](assets/branch-menu.png)
![Creating a new git branch in IntelliJ IDEA](assets/branch-name.png)

### Testing your changes

Each exercise will have gradle tasks that can be executed from the IDE.
To test changes within an exercise, find the gradle task for that folder in the "Gradle" toolbar on the right, open the Tasks > Verification folder and double click `test`.

![Running the Gradle `test` task for a single exercise in IntelliJ IDEA](assets/run-test.png)

### Committing your changes

Once all the changes have been made, you can look at the diffs and commit from the "Commit File" window, which can be reached by selecting VCS > Git > Commit File from the top menu.
If all the changes are acceptable, checkmark all the files that are to be committed, enter a meaningful commit message, and then click "Commit and Push".

![Committing changes to git in IntelliJ IDEA](assets/commit-files.png)

After pushing your changes, [Open a Pull Request](#open-a-pull-request) to contribute them to the Java track.

**NOTE:** Git and gradle commands can still be run in the command line when using and IDE.
The steps outlining how to perform using IDE tools are for convenience only.

## Getting Familiar With the Codebase

There are two objectives to the design of this build:

1. when a problem is built from within the `exercism/java` repo (i.e. when you, the contributor, are developing the exercise), the tests run against the reference solution;
2. when a problem is built outside the `exercism/java` repo (when a participant is solving the exercise), the tests run against the "main" code.

This repo is a multi-project gradle build.

### The `exercises` Module

This is the top-level module, contained in the `exercises` directory. It is a container for the problem submodules.

- its `build.gradle` points the "main" sourceset to the reference solution.
- its `settings.gradle` names each of the subprojects, one for each problem in the set.

### The Problem Submodules

The `exercises` subdirectory contains all the problem submodules.
Each problem/submodule is a subdirectory of the same name as its slug.

- its `build.gradle` names dependencies required to work that problem.
- its `README.md` describes the exercise.

Each problem/submodule has three source sets:

- `src/test/java/` — a test suite defining the edges of the problem
- `.meta/src/reference/java/` — a reference solution that passes all the tests
- `src/main/java/` — starter source file(s).

## Contributing to Concept Exercises

Please read [Implementing a Concept Exercise](reference/implementing-a-concept-exercise.md).

## Contributing to Practice Exercises

Please read [Contributing to Practice Exercises](reference/contributing-to-practice-exercises.md).

[docs-building]: https://exercism.org/docs/building
[docs-building-github]: https://exercism.org/docs/building/github
[docs-building-github-prs]: https://exercism.org/docs/building/github/contributors-pull-request-guide
[docs-java-installation]: https://exercism.org/docs/tracks/java/installation
[forum]: https://forum.exercism.org/
[git-branching]: https://git-scm.com/book/en/v2/Git-Branching-Branches-in-a-Nutshell
[git-rebase]: https://git-scm.com/docs/git-rebase
[github-forking]: https://help.github.com/articles/fork-a-repo/
[github-sync-fork]: https://help.github.com/articles/syncing-a-fork/
[track-repo]: https://github.com/exercism/java
