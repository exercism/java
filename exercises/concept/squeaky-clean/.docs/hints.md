# Hints

## 1. Replace any spaces encountered with underscores

- [This tutorial][chars-tutorial] is useful.
- [Reference documentation][chars-docs] for `char`s is here.
- You can retrieve `char`s from a string using the [charAt][char-at] method.
- You should use a [`StringBuilder`][string-builder] to build the output string.
- See [this method][iswhitespace] for detecting spaces. Remember it is a static method.
- `char` literals are enclosed in single quotes.

## 2. Replace control characters with the upper case string "CTRL"

- See [this method][iscontrol] to check if a character is a control character.

## 3. Convert kebab-case to camel-case

- See [this method][toupper] to convert a character to upper case.

## 4. Omit characters that are not letters

- See [this method][isLetter] to check if a character is a letter.

## 5. Omit Greek lower case letters

- `char`s support the default equality and comparison operators.

[chars-docs]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html
[chars-tutorial]: https://docs.oracle.com/javase/tutorial/java/data/characters.html
[char-at]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/String.html#charAt(int)
[string-builder]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/StringBuilder.html
[iswhitespace]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html#isWhitespace(char)
[iscontrol]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html#isISOControl(char)
[toupper]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html#toUpperCase(char)
[isLetter]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html#isLetter(char)