# About

[Maps][maps] in Java is an interface that holds data in key-value pairs. 

- Keys can be of any [reference type][reference-data-types], but must be unique.
- Values can be of any reference type, they do not have to be unique.

We have three different views that can all be accessed individually

- keys,

```java
Map<String, Integer> map = new HashMap<>();

// Generates a set view of the keys in the hashmap
map.keySet();
```

- values

```java
Map<String, Integer> map = new HashMap<>();

// Generates a set view of the values in the hashmap
map.values();
```

- and key-value mappings.

````java
Map<String, Integer> map = new HashMap<>();

for (String key: map.keySet()) {
    System.out.println("Key = " + key);
    System.out.println("Value = " + map.get(key));
}
````

## Map declaration

Due to Map being an interface, it is recommended we create an object of a class that implements the map interface as shown in the example below that is creating an object of the HashMap class.
There are many useful [built-in functions][start-of-map-functions] that allow you to modify these map objects.

```java
Map<String, Integer> hashmap = new HashMap<>();
```

In regards to the declaration of the HashMap object, the first data type specified `String` represents the data type of the key, and `Integer` represents the data type of the value in the example above.

## Classes that implement Map

We then have the main three classes that are used which implement the Map interface, these are [HashMap][hash-map], [LinkedHashMap][linked-hash-map] and [TreeMap][tree-map].
Below are some key differences in the three classes.

### Hashmap

- Implements the Map interface. 
- No guaranteed order of the elements inserted.
- Null values are allowed.

### LinkedHashMap 

- Implements the Map interface.
- Elements are in the order that they have been inserted.
- Null values are allowed.

### Treemap

- Implements the Map, SortedMap and NavigableMap interfaces.
- Elements are sorted according to the natural ordering, keys will be compared using the compareTo() method by default or keys can be compared using another comparator if specified.
- Null values are **not** allowed.

[maps]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html
[reference-data-types]: https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.3
[hash-map]: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
[linked-hash-map]: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
[tree-map]: https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html
[start-of-map-functions]: https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#size--
