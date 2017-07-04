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
| Exercise added | [Prefer instance methods](#prefer-instance-methods); [Starter implementations](#starter-implementations); [Ignore noninitial tests](#ignore-noninitial-tests) |
| Exercise updated | [Ignore noninitial tests](#ignore-noninitial-tests); [Multiple file submissions](#multiple-file-submissions) |
| Track order changed | [Starter implementations](#starter-implementations); [Multiple file submissions](#multiple-file-submissions) |
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

### Do not make user-facing classes `final`

> Starter implementations and test classes should not include the `final` keyword in class declarations as it isn't strictly necessary and could be confusing to people unfamiliar with Java.

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
