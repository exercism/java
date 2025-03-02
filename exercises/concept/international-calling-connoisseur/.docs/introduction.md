# Introduction

## Maps

A **Map** is a data structure for storing key value pairs.
It is similar to dictionaries in other programming languages.
The [Map][map-javadoc] interface defines operations on a map.

Java has a number of different Map implementations.
[HashMap][hashmap-javadoc] is a commonly used one.

```java
// Make an instance
Map<String, Integer> fruitPrices = new HashMap<>();
```

Add entries to the map using [put][map-put-javadoc].

```java
fruitPrices.put("apple", 100);
fruitPrices.put("pear", 80);
// => { "apple" => 100, "pear" => 80 }
```

Only one value can be associated with each key.
Calling `put` with the same key will update the key's value.

```java
fruitPrices.put("pear", 40);
// => { "apple" => 100, "pear" => 40 }
```

Use [get][map-get-javadoc] to get the value for a key.

```java
fruitPrices.get("apple"); // => 100
```

Use [containsKey][map-containskey-javadoc] to see if the map contains a particular key.

```java
fruitPrices.containsKey("apple");  // => true
fruitPrices.containsKey("orange"); // => false
```

Remove entries with [remove][map-remove-javadoc].

```java
fruitPrices.put("plum", 90);  // Add plum to map
fruitPrices.remove("plum");   // Removes plum from map
```

The [size][map-size-javadoc] method returns the number of entries.

```java
fruitPrices.size();  // Returns 2
```

You can use the [keySet][map-keyset-javadoc] or [values][map-values-javadoc] methods to obtain the keys or the values in a Map as a Set or collection respectively.

```java
fruitPrices.keySet();  // Returns "apple" and "pear" in a set
fruitPrices.values();  // Returns 100 and 80, in a Collection
```

[map-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html
[hashmap-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html
[map-put-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#put(K,V)
[map-get-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#get(java.lang.Object)
[map-containskey-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#containsKey(java.lang.Object)
[map-remove-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#remove(java.lang.Object)
[map-size-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#size()
[map-keyset-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#keySet()
[map-values-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#values()
