# Hints

## General

- [Tutorial on working with enums][java-tutorial-enum-types].

## 1. Parse log level

- There is a [method to get a part of a string][java-docs-substring].
- You can use a [`switch` statement][java-tutorial-switch-statement] to elegantly handle the various log levels.

## 2. Support unknown log level

- There is a special switch case called `default` that can be used to catch unspecified cases.

## 3. Convert log line to short format

- You can add fields and methods to an enum type, see the [tutorial on working with enums][java-tutorial-enum-types].

[java-tutorial-enum-types]: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
[java-tutorial-switch-statement]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
[java-docs-substring]: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#substring-int-int-
