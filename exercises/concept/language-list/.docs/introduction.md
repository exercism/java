* The information provided should give the student just enough context to figure out the solution themselves.
* Only information that is needed to understand the fundamentals of the concept and solve the exercise should be provided. Extra information should be left for the concept's about.md document.
* Links should be used sparingly, if at all. While a link explaining a complex topic like recursion might be useful, for most concepts the links will provide more information than needed so explaining things concisely inline should be the aim.
* Proper technical terms should be used so that the student can easily search for more information.
* Code examples should only be used to introduce new syntax (students should not need to search the web for examples of syntax). In other cases provide descriptions or links instead of code.

<!-- TODO: replace generic information from Elixir track -->

# Introduction

## Lists

**Lists** are the ordered sequence collection in Java.
Unlike arrays, a [`List`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html) can grow in size to accomodate any number of items.
One standard implementation is the `ArrayList` which is backed by a re-sizable array.
Another standard implementation is the `LinkedList` class which is backed by a doubly-linked list.

Lists may be empty or hold any number of items (including duplicates).
They are generically typed to indicate which type of objects they can contain.
For example:

```java
List<String> emptyListOfStrings = List.of();
List<Integer> singleInteger = List.of(1);
List<Boolean> threeBooleans = List.of(true, false, true);
List<Object> listWithMulitipleTypes = List.of("hello", 1, true);
```

`List`s have various helpful methods to add, remove, get, and check for an element to be present:

```java
List<Character> vowels = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'i', 'e', 'a'));
int startingSize = vowels.size(); // 7
vowels.add('u'); // vowels is now ['a', 'e', 'i', 'o', 'i', 'e', 'a', 'u']
char a = vowels.get(0);
boolean hadI = vowels.remove('i'); // true and vowels is now ['a', 'e', 'o', 'i', 'e', 'a', 'u']
boolean hasI = vowels.contains('i'); // true (still have one more left)
```
