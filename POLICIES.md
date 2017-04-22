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
| Exercise added | Prefer instance methods; Starter implementations; Ignore noninitial tests |
| Exercise updated | Multiple file submissions; Ignore noninitial tests |
| Track order updated | Multiple file submissions; Starter implementations |
| New issue observed in track | Good first patches |
| "Good first patch" issue completed | Good first patches |
| Installing Java instructions updated | Simple onboarding |

## Policy Descriptions

### Prefer instance methods [[1](https://github.com/exercism/xjava/issues/177#issuecomment-261291741)]

Most (all?) exercises should be implemented in the form of instance methods since they contain "domain logic" and we (Exercism) want to encourage exemplary software.

### Starter implementations [[1](https://github.com/exercism/xjava/issues/178)]

- Exercises 1-10: provide stubs for all required methods.
- Exercises 11-20: provide stubs for all methods required by the first test; comment-out the bodies of any tests that require non-stubbed methods.
- Exercises 21+: provide no stubs, but mention any "interesting" interface aspects in the HINT.md file (which gets merged into the README.md for the exercise).

### Ignore noninitial tests [[1](https://github.com/exercism/xjava/issues/101#issuecomment-249349204)]

All but the first test in an exercise test suite should be annotated `@Ignore`.

### Multiple file submissions [[1](https://github.com/exercism/xjava/issues/365#issuecomment-292533120)]

The first exercise in the track whose test suite mandates multiple solution files should be accompanied by a HINT.md file reminding the practitioner that the CLI supports multiple file submissions.

### Good first patches [[1](https://github.com/exercism/xjava/issues/220#issue-196447088)]

Aim to keep 10-20 small and straightforward issues open at eny given time. Identify any such issues by applying the "Good first patch" label.

### Simple onboarding [[1](https://github.com/exercism/xjava/issues/395#issue-215734887)]

The Installing Java instructions should seek to minimize the number of steps and the number of concepts a new-to-the-track practitioner needs to learn to get to coding.
