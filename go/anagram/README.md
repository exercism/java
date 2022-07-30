# Anagram

Welcome to Anagram on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

An anagram is a rearrangement of letters to form a new word: for example `"owns"` is an anagram of `"snow"`.
A word is not its own anagram: for example, `"stop"` is not an anagram of `"stop"`.

Given a target word and a set of candidate words, this exercise requests the anagram set: the subset of the candidates that are anagrams of the target.

The target and candidates are words of one or more ASCII alphabetic characters (`A`-`Z` and `a`-`z`).
Lowercase and uppercase characters are equivalent: for example, `"PoTS"` is an anagram of `"sTOp"`, but `StoP` is not an anagram of `sTOp`.
The anagram set is the subset of the candidate set that are anagrams of the target (in any order).
Words in the anagram set should have the same letter case as in the candidate set.

Given the target `"stone"` and candidates `"stone"`, `"tones"`, `"banana"`, `"tons"`, `"notes"`, `"Seton"`, the anagram set is `"tones"`, `"notes"`, `"Seton"`.

## Source

### Created by

- @mikegehard

### Contributed to by

- @alebaffa
- @bitfield
- @ekingery
- @ferhatelmas
- @henrik
- @hilary
- @ilmanzo
- @kf8a
- @kytrinyx
- @leenipper
- @markijbema
- @petertseng
- @robphoenix
- @sebito91
- @strangeman
- @tleen
- @tompao
- @eklatzer

### Based on

Inspired by the Extreme Startup game - https://github.com/rchatley/extreme_startup