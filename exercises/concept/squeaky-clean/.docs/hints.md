# Hints

## 1. Replace any spaces encountered with underscores

- [This tutorial][chars-tutorial] is useful.
- [Reference documentation][chars-docs] for `char`s is here.
- You can retrieve `char`s from a string using the [charAt][char-at] method.
- You should use a [`StringBuilder`][string-builder] to build the output string.
- See [this method][iswhitespace] for detecting spaces. Remember it is a static method.
- See [this method][isdigit] for detecting numbers.
- `char` literals are enclosed in single quotes.

## 2. Convert kebab-case to camel-case

- See [this method][toupper] to convert a character to upper case.

## 3. Omit characters that are not letters

- See [this method][isletter] to check if a character is a letter.

[chars-docs]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html
[chars-tutorial]: https://docs.oracle.com/javase/tutorial/java/data/characters.html
[char-at]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/String.html#charAt(int)
[string-builder]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/StringBuilder.html
[iswhitespace]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html#isWhitespace(char)
[toupper]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html#toUpperCase(char)
[isletter]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html#isLetter(char)
[isdigit]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html#isDigit(char)
