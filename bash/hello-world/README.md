# Hello World

Welcome to Hello World on Exercism's Bash Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

The classical introductory exercise. Just say "Hello, World!".

["Hello, World!"](http://en.wikipedia.org/wiki/%22Hello,_world!%22_program) is
the traditional first program for beginning programming in a new language
or environment.

The objectives are simple:

- Write a function that returns the string "Hello, World!".
- Run the test suite and make sure that it succeeds.
- Submit your solution and check it at the website.

If everything goes well, you will be ready to fetch your first real exercise.

Unlike many other languages here, bash is a bit of a special snowflake.
If you are on a Mac or other unix-y platform, you almost definitely
already have bash. In fact, anything you type into the terminal is
likely going through bash.

The downside to this is that there isn't much of a development
ecosystem around bash like there is for other languages, and there are
multiple versions of bash that can be frustratingly incompatible. Luckily
we shouldn't hit those differences for these basic examples, and if you
can get the tests to pass on your machine, we are doing great.

## Installation

As mentioned above, if you are on a unix-like OS (Mac OS X, Linux, Solaris,
etc), you probably already have bash.

## Testing

As there isn't much of a bash ecosystem, there also isn't really a de
facto leader in the bash testing area. For these examples we are using
[bats](https://github.com/bats-core/bats-core). You should be able to
install it from your favorite package manager, on OS X with homebrew
this would look something like this:

```
$ brew install bats-core
==> Downloading
https://github.com/bats-core/bats-core/archive/v1.2.0.tar.gz
==> Downloading from
https://codeload.github.com/bats-core/bats-core/tar.gz/v1.2.0
########################################################################
100.0%
==> ./install.sh /opt/boxen/homebrew/Cellar/bats/1.2.0
🍺  /opt/boxen/homebrew/Cellar/bats/1.2.0: 10 files, 60K, built in 2
seconds
```

## Source

### Contributed to by

- @adelcambre
- @bkhl
- @budmc29
- @coreygo
- @glennj
- @guygastineau
- @IsaacG
- @kenden
- @kotp
- @kytrinyx
- @MattLewin
- @platinumthinker
- @quartzinquartz
- @rootulp
- @sjwarner-bp
- @Smarticles101
- @ZapAnton

### Based on

This is an exercise to introduce users to using Exercism - http://en.wikipedia.org/wiki/%22Hello,_world!%22_program