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
| Exercise added/updated | [Prefer instance methods](#prefer-instance-methods); [Avoid using final](#avoid-using-final); [Adhere to best practices](#adhere-to-best-practices); [Starter implementations](#starter-implementations); [Ignore noninitial tests](#ignore-noninitial-tests); [Multiple file submissions](#multiple-file-submissions); [Name test class after class under test](#name-test-class-after-class-under-test); [Add hint for the first exercises without starter implementation](#add-hint-for-the-first-exercises-without-starter-implementation); [Reference tutorial in the first exercises](#reference-tutorial-in-the-first-exercises); [Avoid returning null](#avoid-returning-null); [Use assertThrows](#use-assertthrows); [Using other assertion libraries](#using-other-assertion-libraries)
| Track rearranged | [Starter implementations](#starter-implementations); [Multiple file submissions](#multiple-file-submissions) |
| New issue observed in track | [Good first issues](#good-first-issues) |
| "Good first issue" issue completed | [Good first issues](#good-first-issues) |
| Installing Java instructions updated | [Simple onboarding](#simple-onboarding) |

## Policy Descriptions

### Prefer instance methods

> Most (all?) exercises should be implemented in the form of instance methods since they contain "domain logic" and we (Exercism) want to encourage exemplary software.

References: [[1](https://github.com/exercism/java/issues/177#issuecomment-261291741)]

### Starter implementations

> - Exercises of difficulty 4 or lower: provide stubs for all required constructors and methods. This means that you need to provide stubs for those constructors or methods that are necessary to pass all tests. E.g. stubs for private methods may be skipped.
Stubs should include the following body:
    `throw new UnsupportedOperationException("Delete this statement and write your own implementation.");`
> - Exercises of difficulty 5 or higher: copy the StubTemplate.java file (provided [here](https://github.com/exercism/java/tree/main/_template/src/main/java)) and rename it to fit the exercise. For example, for the exercise linked-list the file could be named LinkedList.java. Then either (1) add hints to the hints.md file (which gets merged into the README.md for the exercise) or (2) provide stubs as above for exercises that demand complicated method signatures.

References: [[1](https://github.com/exercism/java/issues/178)], [[2](https://github.com/exercism/java/pull/683#discussion_r125506930)], [[3](https://github.com/exercism/java/issues/977)], [[4](https://github.com/exercism/java/issues/1721)]

### Avoid using final

> Avoid using `final` in user-facing code. Liberal use of the `final` keyword remains controversial. It adds little value to test suites, and if included in starter implementations, places implicit restrictions on user solutions.

### Adhere to best practices

> Ensure that all Java code adheres to the best practices listed below:
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

> Aim to keep 10-20 small and straightforward issues open at any given time. Identify any such issues by applying the "good first issue" label. You can view the current list of these issues [here](https://github.com/exercism/java/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+issue%22).

References: [[1](https://github.com/exercism/java/issues/220#issue-196447088)], [[2](https://github.com/exercism/java/issues/1669)]

### Simple onboarding

> The Installing Java instructions should seek to minimize the number of steps and the number of concepts a new-to-the-track practitioner needs to learn to get to coding.

References: [[1](https://github.com/exercism/java/issues/395#issue-215734887)]

### Name test class after class under test

> If you're testing a class called `SomeClassName` then your test class should be called `SomeClassNameTest`.

> The exception to this is if the tests are split into several test classes where each test class tests different functionality. In that case each class should be named `SomeClassNameFunctionalityTest` where `Functionality` is the name of the functionality to be tested in that class. See the [clock exercise](https://github.com/exercism/java/tree/main/exercises/practice/clock) as an example.

References: [[1](https://github.com/exercism/java/issues/697)]

### Add hint for the first exercises without starter implementation

> According to the starter implementation policy, any exercise with difficulty 4 or lower should have starter implementation.
> Any exercise with difficulty 5 or above will have no starter implementation (unless its signature is very complicated).
> This could be confusing to users when tackling their first exercise with difficulty 5 when they are used to starter implementation being provided.

> Therefore a hints.md file should be added to the .meta directory for every exercise with difficulty 5.
> This file should explain what they need to do when there is no starter implementation.
> The files should all be the same so you can copy it from any other exercise with difficulty 5, e.g. [flatten-array](https://github.com/exercism/java/tree/main/exercises/pratice/flatten-array/.meta/hints.md).

> We add the file to every exercise with difficulty 5 because the structure of the track means that we don't know which exercise will be the first one without starter implementation that a user will be faced with.

References: [[1](https://github.com/exercism/java/issues/1075)]

### Reference tutorial in the first exercises

> The hello world exercise has an extensive tutorial on how to solve exercism exercises.
> This tutorial would probably be useful to have as a reference when solving some of the other earlier exercises as well.
> Therefore any exercise with difficulty less than 3 should have a hints.md file which references [the hello world tutorial](https://github.com/exercism/java/blob/main/exercises/practice/hello-world/.docs/instructions.append.md#tutorial).

References: [[1](https://github.com/exercism/java/issues/1389)]

### Avoid returning null

> The [canonical data](https://github.com/exercism/problem-specifications/tree/main/exercises) for each exercise intentionally doesn't deal with error handling.
> When an error has occured or a method can't return anything, the canonical data will just mark that as `"expected": null`.
> This is because error handling varies from language to language, so the canonical data is leaving it up to each language track to decide how to deal with those situations.
> It doesn't mean that the method needs to return `null`.

> In Java it's considered bad practice to return `null`.
> If you return `null` then the user of the method has to remember to check for `null` and they have to look at the implementation of the method to find out that this is necessary.

> It's considered best practice to deal with errors and unexpected circumstances by throwing exceptions.
> If you throw an exception then you force the user to deal with the problem.
> You can either define your own exception (see [the triangle exercise](https://github.com/exercism/java/blob/main/exercises/practice/triangle/.meta/src/reference/java/TriangleException.java) for an example) or use a predefined one (see [the collatz-conjecture exercise](https://github.com/exercism/java/blob/main/exercises/practice/collatz-conjecture/src/test/java/CollatzCalculatorTest.java) for an example).

> Another option is to use [Optionals](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html).
> This can be more suitable if the case you want to deal with isn't an exceptional occurence, but rather an expected scenario, e.g. a search method not finding what it was searching for.
> See [the word-search exercise](https://github.com/exercism/java/blob/main/exercises/practice/word-search/src/test/java/WordSearcherTest.java) for an example where `Optional` is used.

References: [[1](https://www.codebyamir.com/blog/stop-returning-null-in-java)]

### Use assertThrows

> Some exercises expect exceptions to be thrown in the tests.
> The exercises on this track are all using [`org.junit.Assert.assertThrows`](https://junit.org/junit4/javadoc/latest/org/junit/Assert.html#assertThrows(java.lang.Class,%20org.junit.function.ThrowingRunnable)) instead of `@Test(expected = SomeException.class)`.
> `assertThrows` is more powerful than using the `@Test` annotation.
> With this method you can assert that a given function call (specified, for instance, as a lambda expression or method reference) results in a particular type of exception being thrown.
> In addition it returns the exception that was thrown, so that further assertions can be made (e.g. to verify that the message and cause are correct).
> Furthermore, you can make assertions on the state of a domain object after the exception has been thrown.
> To be consistent, please use `assertThrows` whenever you expect an exception to be thrown.

> See [the triangle tests](https://github.com/exercism/java/blob/main/exercises/practice/triangle/src/test/java/TriangleTest.java) for an example of where `assertThrows` is used.

References: [[1](https://github.com/junit-team/junit4/wiki/Exception-testing)]

### Using other assertion libraries

> Some exercises have expected results that may be better handled by another assertion library.
> While the default will continue to be using JUnit's assertions (eg. `org.junit.Assert.assertEquals`), we do allow [AssertJ](https://assertj.github.io/doc/) as well.
> All other assertion libraries (eg. [Hamcrest](http://hamcrest.org/JavaHamcrest/) and [Truth](https://truth.dev/)) are banned.

References: [[1](https://github.com/exercism/java/issues/1803)]
