# Introduction

[Maps][maps] in Java is an interface that holds data in key-value pairs.

- Keys can be of any [reference type][reference-data-types], but must be unique.
- Values can be of any reference type, they do not have to be unique.

## Map declaration

Due to Map being an interface, it is recommended we create an object of a class that implements the map interface as shown in the example below that is creating an object of the HashMap class.
There are many useful [built-in functions][start-of-map-functions] that allow you to modify these map objects.

```java
Map<String, Integer> hashmap = new HashMap<>();
```

In regards to the declaration of the HashMap object, the first data type specified `String` represents the data type of the key, and `Integer` represents the data type of the value in the example above.

## Adding values to a Map

The [put][put] method is what is used to add a value to a map. The first argument passed will be the key which must be unique
and the second argument will be the value. Both the key and value can be of any data type

```java
Map<String, Integer> hashmap = new HashMap<>();

hashmap.put(String key, Integer value)
```


## Retrieving values from a Map

The [get][get] method is used to retrieve values from a map. Only one argument is passed to this method which is the key of the map entry you want to retrieve.


```java
Map<String, Integer> hashmap = new HashMap<>();

hashmap.get(String key)
```


[maps]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html
[reference-data-types]: https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.3
[start-of-map-functions]: https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#size--
[put]: google
[get]: google
