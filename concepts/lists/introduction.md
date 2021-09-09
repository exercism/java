# Introduction to Lists

**Lists** are the ordered sequence collection in Java.
Unlike arrays, a [`List`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html) can grow in size to accomodate any number of items.
One standard implementation is the `ArrayList` which is backed by a re-sizable array.
Another standard implementation is the `LinkedList` class which is backed by a doubly-linked list.

`List`s may be empty or hold any number of items (including duplicates).
`List`s are a **generic interface** typed to indicate which type of objects they can contain.
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
char a = vowels.get(0); // 'a'
boolean hadI = vowels.remove('i'); // true and vowels is now ['a', 'e', 'o', 'i', 'e', 'a', 'u']
boolean hasI = vowels.contains('i'); // true (still have one more left)
```
