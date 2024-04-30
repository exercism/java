# Design

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `actionable`: If the solution calculates the Hamming distance each time `getHammingDistance()` is called,
  instruct the student to calculate the Hamming distance once in the constructor.
  Explain how this is more efficient.
- `actionable`: If the solution hard-codes the DNA cells as character literals (`A`, `C`, `G`, `T`) when comparing strands,
  inform the student that their solution should be able to calculate the Hamming distance between any two strings,
  regardless of their contents.
- `informative`: If the solution uses `Instream.reduce()`, inform the student that it can be simplified to `Instream.filter().count()`.

[analyzer]: https://github.com/exercism/java-analyzer
