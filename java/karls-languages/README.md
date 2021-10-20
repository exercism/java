# Karl's Languages

Welcome to Karl's Languages on Exercism's Java Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Generic Types

A **generic type** is a generic class or interface that is parameterized over types.
This allows the compiler to enforce type safety on the class or interface.

Consider this non-generic `Container` interface:

```java
class Container {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
```

Since it accepts and returns Object types, it works with any non-primitive type.
However, this comes at a cost because some code may call `get` expecting `Integer`s while other code calls `set` adding `String`s resulting in a runtime exception.

A **generic class** and **generic interface** have the following formats:

```java
class ClassName<T1, T2, ..., Tn> { ... }
interface InterfaceName<T1, T2, ..., Tn> { ... }
```

The type parameter section, delimited by angle brackets (`<>`), following the class or interface name specifies the type parameters (also called type variables) `T1`, `T2`, ..., and `Tn`.
These can be used inside the body of the class or interface to get generic type safety.

Here is the generic version of `Container`:

```java
class Container<E> {
    private E object;

    public void set(E object) { this.object = object; }
    public E get() { return object; }
}
```

When created, now we have to declare what type it holds and the compiler will enforce that constraint:

```java
// empty <> can infer from context
Container<String> stringContainer = new Container<>();
// compiler knows this is a String, so it is allowed
stringContainer.set("Some string");
// no cast needed, compiler knows it is a String
String result = stringContainer.get();
// this causes a compiler error:
stringContainer.set(42);
```

## Lists

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

## Instructions

Karl wants to keep track of a list of languages to learn on Exercism's website.
Karl needs to be able to add new languages, remove old ones and check if certain languages are in the list.
It would be very exciting if Karl wants to learn Java or Kotlin!

## 1. Define a function to check if the language list is empty

Karl needs to know if his list of languages ever becomes empty so he can go find more to learn!
Define a method called `isEmpty` which returns `true` if there are no languages in the list.

```java
if (languageList.isEmpty()) {
    findMoreLanguagesToLearn();
}
```

## 2. Define a function to add a language to the list

Karl is looking forward to learning Kotlin and Python!
Help Karl get started by defining a method called `addLanguage` which takes the language he wants to learn and adds it to the list.

```java
languageList.addLanguage("Kotlin");
languageList.addLanguage("Python");
```

## 3. Define a function to remove a language from the list

Karl decided he does not want to learn Scala right now.
Help Karl remove it from the list by defining a method called `removeLanguage` which takes the language he is removing and removes it from the list.

```java
languageList.removeLanguage("Scala");
```

## 4. Define a function to return the first item in the list

Karl wants to remember the first language he added to the list (that is still in the list).
Define a method called `firstLanguage` that returns the first language in the list.

```java
String kotlin = languageList.firstLanguage(); // "Kotlin"
```

## 5. Define a function to return how many languages are in the list

Karl needs to know how many languages he is trying to learn.
Help Karl find the answer by defining a method called `count` which returns the number of languages in the list.

```java
int two = languageList.count(); // 2
```

## 6. Define a function to determine if a language is in the list

Karl is trying to remember if he wanted to learn Python or Ruby.
Define a method called `containsLanguage` which takes the language he is asking about so Karl can find out!

```java
boolean learningPython = languageList.containsLanguage("Python"); // true
boolean learningRuby = languageList.containsLanguage("Ruby"); // false
```

## 7. Define a function to determine if the list is exciting

If Karl wants to learn Java or Kotlin, that is very exciting!
Define a method called `isExciting` that returns true if Karl wants to learn Java or Kotlin.

```java
javaLanguageList.isExciting() // true
neitherKotlinNorJavaLanguageList.isExciting() // false
```

## Source

### Created by

- @jmrunkle