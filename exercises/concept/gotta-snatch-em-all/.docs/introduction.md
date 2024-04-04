# Introduction

## Sets

A [`Set`][set-docs] is an unordered collection that (unlike `List`) is guaranteed to not contain any duplicate values.

The generic type parameter of the `Set` interface denotes the type of the elements contained in the `Set`:

```java
Set<Integer> ints = Set.of(1, 2, 3);
Set<String> strings = Set.of("alpha", "beta", "gamma");
Set<Object> mixed = Set.of(1, false, "foo");
```

Note that the `Set.of()` method creates an [_unmodifiable_][unmodifiable-set-docs] `Set` instance.
Trying to call methods like `add` and `remove` on this instance will result in an exception at run-time.

To create a modifiable `Set`, you need to instantiate a class that implements the `Set` interface.
The most-used built-in class that implements this interface is the [`HashSet`][hashset-docs] class.

```java
Set<Integer> ints = new HashSet<>();
```

The `Set` interface extends from the [`Collection`][collection-docs] and [`Iterable`][iterable-docs] interfaces, and therefore shares a lot of methods with other types of collections.
A notable difference to the `Collection` interface, however, is that methods like `add` and `remove` return a `boolean` (instead of `void`) which indicates whether the item was contained in the set when that method was called:

```java
Set<Integer> set = new HashSet<>();
set.add(1);
// => true
set.add(2);
// => true
set.add(1);
// => false
set.size();
// => 2
set.contains(1);
// => true
set.contains(3);
// => false
set.remove(3);
// => false
set.remove(2);
// => true
set.size();
// => 1
```

[collection-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Collection.html
[hashset-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashSet.html
[iterable-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Iterable.html
[set-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html
[unmodifiable-set-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html#unmodifiable
