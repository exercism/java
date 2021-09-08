# Introduction

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
