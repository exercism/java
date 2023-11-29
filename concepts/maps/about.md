# About

[Maps][maps] in Java is an interface that holds data in key-value pairs. 

- Keys can be of any [reference type][reference-data-types], but must be unique.
- Values can be of any reference type, they do not have to be unique.

The Map interface provides three collection views that can all be accessed individually

- set of keys,

```java
Map<String, Integer> hashmap = new HashMap<String, Integer>();

// Generates a set view of the keys in the hashmap
hashmap.keySet();
```

- collection of values

```java
Map<String, Integer> hashmap = new HashMap<String, Integer>();

// Generates a set view of the values in the hashmap
hashmap.values();
```

- set of key-value mappings.

````java
Map<String, Integer> hashmap = new HashMap<String, Integer>();

for (String key: map.keySet()) {
    System.out.println("Key = " + key);
    System.out.println("Value = " + map.get(key));
}
````

Due to Map being an interface, we must create an object of a class that implements the map interface.

```java
Map<String, Integer> hashmap = new HashMap<String, Integer>();
```

The first data type specified `String` represents the data type of the key, and `Integer` represents the data type of the value in the example above.

## SortedMap

There are two map interfaces in Java, Map and [SortedMap][sorted-map] which extends the Map interface.
The main difference in Map and SortedMap is that the elements in a SortedMap are in sorted order.
The sorting order of the elements in a SortedMap are by the natural order of the keys, or by a specified comparator.

## Classes that implement Map

We then have three classes which implement the Map interface, these are [HashMap][hash-map], [LinkedHashMap][linked-hash-map] and [TreeMap][tree-map].

### Hashmap



### LinkedHashMap 

### Treemap



[maps]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html
[reference-data-types]: https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.3
[start-of-map-methods]: https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#size--
[sorted-map]: https://docs.oracle.com/javase/8/docs/api/java/util/SortedMap.html
[hash-map]: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
[linked-hash-map]: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
[tree-map]: https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html