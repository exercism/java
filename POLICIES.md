# Track Policies

This document:

- describes all current track-wide policies; and
- lists all policies that should be reviewed in response to any given track event.

Maintainers should refer to this document each time they review a pull request.

Our policies are not set-in-stone. They represent directions chosen at a point in time with the information/context available at that time. We actively encourage contributors to review and critique them. If you have read through the references that informed an existing policy and still feel it should be improved or removed, please comment and describe:

1. your alternative perspective;
2. your proposed changes; and
3. how your proposal balances your own perspective with those already raised during prior discussions.

## Event Checklist

| Track Event | Policies to review |
|:------------|:-----------------|
| Exercise added/updated | [Prefer instance methods](#prefer-instance-methods); [Avoid using final](#avoid-using-final); [Adhere to best practices](#adhere-to-best-practices); [Starter implementations](#starter-implementations); [Ignore noninitial tests](#ignore-noninitial-tests); [Multiple file submissions](#multiple-file-submissions); [Name test class after class under test](#name-test-class-after-class-under-test)
| Track rearranged | [Starter implementations](#starter-implementations); [Multiple file submissions](#multiple-file-submissions) |
| New issue observed in track | [Good first patches](#good-first-patches) |
| "Good first patch" issue completed | [Good first patches](#good-first-patches) |
| Installing Java instructions updated | [Simple onboarding](#simple-onboarding) |

## Policy Descriptions

### Prefer instance methods

> Most (all?) exercises should be implemented in the form of instance methods since they contain "domain logic" and we (Exercism) want to encourage exemplary software.

References: [[1](https://github.com/exercism/java/issues/177#issuecomment-261291741)]

### Starter implementations

> - Exercises 1-20: provide stubs for all required constructors and methods. Stubs should include the following body:
    `throw new UnsupportedOperationException("Delete this statement and write your own implementation.");`
> - Exercises 21+: provide no stubs by default, but either (1) add hints to the HINTS.md file (which gets merged into the README.md for the exercise) or (2) provide stubs as in exercises 1-20 for exercises that demand complicated method signatures.

References: [[1](https://github.com/exercism/java/issues/178)], [[2](https://github.com/exercism/java/pull/683#discussion_r125506930)]

### Avoid using final

> Avoid using `final` in user-facing code. Liberal use of the `final` keyword remains controversial. It adds little value to test suites, and if included in starter implementations, places implicit restrictions on user solutions.

### Adhere to best practices

> Ensure that all Java code adheres to the best practices listed below:
> - minimize the accessibility of classes and members ([Effective Java, item 13](http://jtechies.blogspot.com/2012/07/item-13-minimize-accessibility-of.html))

### Ignore noninitial tests

> All but the first test in an exercise test suite should add `@Ignore("Remove to run test")` (single test) or `@Ignore("Remove to run tests")` (parametrized test) on the line before the corresponding `@Test` annotation.

References: [[1](https://github.com/exercism/java/issues/101#issuecomment-249349204)]

### Multiple file submissions

> The first exercise in the track whose test suite mandates multiple solution files should be accompanied by a HINTS.md file reminding the practitioner that the CLI supports multiple file submissions.

References: [[1](https://github.com/exercism/java/issues/365#issuecomment-292533120)]

### Good first patches

> Aim to keep 10-20 small and straightforward issues open at eny given time. Identify any such issues by applying the "Good first patch" label. You can view the current list of these issues [here](https://github.com/exercism/java/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+patch%22).

References: [[1](https://github.com/exercism/java/issues/220#issue-196447088)]

### Simple onboarding

> The Installing Java instructions should seek to minimize the number of steps and the number of concepts a new-to-the-track practitioner needs to learn to get to coding.

References: [[1](https://github.com/exercism/java/issues/395#issue-215734887)]

### Name test class after class under test

> If you're testing a class called `SomeClassName` then your test class should be called `SomeClassNameTest`. 

> The exception to this is if the tests are split into several test classes where each test class tests different functionality. In that case each class should be named `SomeClassNameFunctionalityTest` where `Functionality` is the name of the functionality to be tested in that class. See the [clock exercise](https://github.com/exercism/java/tree/master/exercises/clock) as an example.

References: [[1](https://github.com/exercism/java/issues/697)]
