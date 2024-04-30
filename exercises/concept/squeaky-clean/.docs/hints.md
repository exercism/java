# Hints

## 1. Replace any spaces encountered with underscores

- [This tutorial][chars-tutorial] is useful.
- You can retrieve `char`s from a string using the [charAt][char-at] method.
- You should use a [`StringBuilder`][string-builder] to build the output string.
- Check the [Character][chars-docs] documentation for a method to detect whitespaces. Remember it is a static method.
- `char` literals are enclosed in single quotes.

## 2. Convert kebab-case to camel-case

- Check the [Character][chars-docs] documentation for a method to convert a character to upper case. Remember it is a static method.

## 3. Convert leetspeak to normal text

- Check the [Character][chars-docs] documentation for a method to detect when a character is a digit. Remember it is a static method.

## 4. Omit characters that are not letters

- Check the [Character][chars-docs] documentation for a method to detect when a character is a letter. Remember it is a static method.

[chars-docs]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html
[chars-tutorial]: https://docs.oracle.com/javase/tutorial/java/data/characters.html
[char-at]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/String.html#charAt(int)
[string-builder]: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/StringBuilder.html
