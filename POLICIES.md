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

| Track Event                          | Policies to review                                                                                                                  |
| :----------------------------------- | :---------------------------------------------------------------------------------------------------------------------------------- |
| Exercise added/updated               | [Prefer instance methods](#prefer-instance-methods)                                                                                 |
|                                      | [Avoid using final](#avoid-using-final)                                                                                             |
|                                      | [Adhere to best practices](#adhere-to-best-practices)                                                                               |
|                                      | [Starter implementations](#starter-implementations)                                                                                 |
|                                      | [Ignore noninitial tests](#ignore-noninitial-tests)                                                                                 |
|                                      | [Multiple file submissions](#multiple-file-submissions)                                                                             |
|                                      | [Name test class after class under test](#name-test-class-after-class-under-test)                                                   |
|                                      | [Reference tutorial in the first exercises](#reference-tutorial-in-the-first-exercises)                                             |
|                                      | [Avoid returning null](#avoid-returning-null)                                                                                       |
|                                      | [Prefer AssertJ assertions](#prefer-assertj-assertions)                                                                             |
| Track rearranged                     | [Starter implementations](#starter-implementations)                                                                                 |
|                                      | [Multiple file submissions](#multiple-file-submissions)                                                                             |
| New issue observed in track          | [Good first issues](#good-first-issues)                                                                                             |
| "Good first issue" issue completed   | [Good first issues](#good-first-issues)                                                                                             |
| Installing Java instructions updated | [Simple onboarding](#simple-onboarding)                                                                                             |

## Policy Descriptions

### Prefer instance methods

> Most (all?) exercises should be implemented in the form of instance methods since they contain "domain logic" and we (Exercism) want to encourage exemplary software.

References: [[1](https://github.com/exercism/java/issues/177#issuecomment-261291741)]

### Starter implementations

> Provide stubs for all required constructors and methods. This means that you need to provide stubs for those constructors or methods that are necessary to pass all tests. E.g. stubs for private methods may be skipped.
> Stubs should include the following body:
>
> ```java
> throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
> ```

Reference: [[1](https://github.com/exercism/java/issues/2133)]

### Avoid using final

> Avoid using `final` in user-facing code. Liberal use of the `final` keyword remains controversial. It adds little value to test suites, and if included in starter implementations, places implicit restrictions on user solutions.

### Adhere to best practices

> Ensure that all Java code adheres to the best practices listed below:
>
> - Minimize the accessibility of classes and members ([Effective Java, item 13](http://jtechies.blogspot.com/2012/07/item-13-minimize-accessibility-of.html))
> - Always use curly brackets in `if statements`. This makes your code easier to maintain and easier to read ([Oracle style guide, item 7.4](http://www.oracle.com/technetwork/java/javase/documentation/codeconventions-142311.html#431))

```java
// Please do this
if (condition) {
    doSomething();
}

// Please don't do this
if (condition)
    doSomething();

if (condition) doSomething();
```

> - Always put opening curly bracket not on a newline ([Oracle style guide, item 7.2](http://www.oracle.com/technetwork/java/javase/documentation/codeconventions-142311.html#431))

```java
// Please do this
for (int i = 0; i < 10; i++) {
    ...
}

// Please don't do this
for (int i = 0; i < 10; i++)
{
    ...
}
```

### Ignore noninitial tests

> All but the first test in an exercise test suite should add `@Ignore("Remove to run test")` (single test) or `@Ignore("Remove to run tests")` (parametrized test) on the line before the corresponding `@Test` annotation.

References: [[1](https://github.com/exercism/java/issues/101#issuecomment-249349204)]

### Multiple file submissions

> The first exercise in the track whose test suite mandates multiple solution files should be accompanied by a hints.md file reminding the practitioner that the CLI supports multiple file submissions.

References: [[1](https://github.com/exercism/java/issues/365#issuecomment-292533120)]

### Good first issues

> Aim to keep 10-20 small and straightforward issues open at any given time. Identify any such issues by applying the "good first issue" label. You can view the current list of labeled issues [on GitHub](https://github.com/exercism/java/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+issue%22).

References: [[1](https://github.com/exercism/java/issues/220#issue-196447088)], [[2](https://github.com/exercism/java/issues/1669)]

### Simple onboarding

> The Installing Java instructions should seek to minimize the number of steps and the number of concepts a new-to-the-track practitioner needs to learn to get to coding.

References: [[1](https://github.com/exercism/java/issues/395#issue-215734887)]

### Name test class after class under test

> If you're testing a class called `SomeClassName` then your test class should be called `SomeClassNameTest`.
>
> The exception to this is if the tests are split into several test classes where each test class tests different functionality. In that case each class should be named `SomeClassNameFunctionalityTest` where `Functionality` is the name of the functionality to be tested in that class. See the [clock exercise](https://github.com/exercism/java/tree/main/exercises/practice/clock) as an example.

References: [[1](https://github.com/exercism/java/issues/697)]

### Reference tutorial in the first exercises

> The hello world exercise has an extensive tutorial on how to solve exercism exercises.
> This tutorial would probably be useful to have as a reference when solving some of the other earlier exercises as well.
> Therefore any exercise with difficulty less than 3 should have a instructions.append.md file which references [the hello world tutorial](https://github.com/exercism/java/blob/main/exercises/practice/hello-world/.docs/instructions.append.md#tutorial).

References: [[1](https://github.com/exercism/java/issues/1389)]
Note: The PRs in the referenced issue uses hints.md, but this is now instructions.append.md (see [commit 52617354](https://github.com/exercism/java/commit/5261735435192b5b10535b2fcf41c81b638e5de5))

### Avoid returning null

> The [canonical data](https://github.com/exercism/problem-specifications/tree/main/exercises) for each exercise intentionally doesn't deal with error handling.
> When an error has occured or a method can't return anything, the canonical data will just mark that as `"expected": null`.
> This is because error handling varies from language to language, so the canonical data is leaving it up to each language track to decide how to deal with those situations.
> It doesn't mean that the method needs to return `null`.
>
> In Java it's considered bad practice to return `null`.
> If you return `null` then the user of the method has to remember to check for `null` and they have to look at the implementation of the method to find out that this is necessary.
>
> It's considered best practice to deal with errors and unexpected circumstances by throwing exceptions.
> If you throw an exception then you force the user to deal with the problem.
> You can either define your own exception (see [the triangle exercise](https://github.com/exercism/java/blob/main/exercises/practice/triangle/.meta/src/reference/java/TriangleException.java) for an example) or use a predefined one (see [the collatz-conjecture exercise](https://github.com/exercism/java/blob/main/exercises/practice/collatz-conjecture/src/test/java/CollatzCalculatorTest.java) for an example).
>
> Another option is to use [Optionals](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html).
> This can be more suitable if the case you want to deal with isn't an exceptional occurence, but rather an expected scenario, e.g. a search method not finding what it was searching for.
> See [the word-search exercise](https://github.com/exercism/java/blob/main/exercises/practice/word-search/src/test/java/WordSearcherTest.java) for an example where `Optional` is used.

References: [[1](https://www.codebyamir.com/blog/stop-returning-null-in-java)]

### Prefer AssertJ assertions

> Use [AssertJ](https://assertj.github.io/doc/) assertions over JUnit assertions in exercise test suites.
> AssertJ assertions are more robust and provide more readable output in assertion failures.
> This is especially useful for students using the online editor, as the output of the assertion is all they have to debug test failures in their iterations.
>
> All other assertion libraries (eg. [Hamcrest](http://hamcrest.org/JavaHamcrest/) and [Truth](https://truth.dev/)) should not be used.

References: [[1](https://github.com/exercism/java/issues/1803)], [[2](https://github.com/exercism/java/issues/2147)]
