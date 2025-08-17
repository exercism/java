# About

Streams in Java offer a modern, functional approach to processing data. Instead of writing verbose loops, you can build pipelines that transform collections with clarity and elegance.

Streams are built on three key components:

1. **Source** – Typically a collection like a `List` or `Set`.
2. **Intermediate Operations** – Transformations such as `filter`, `map`, or `sorted`.
3. **Terminal Operation** – Produces a result, like `collect`, `count`, or `forEach`.

```java
List<String> names = List.of("Dharshini", "Naveen", "Selena");

List<String> filtered = names.stream()
    .filter(name -> name.startsWith("N"))
    .collect(Collectors.toList());

// => ["Naveen"]
```


[Java Stream API Overview]:https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
[Collectors Class]:https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
[Java Functional Programming with Streams]:https://www.baeldung.com/java-8-streams
[Stream Operations Explained]:https://www.geeksforgeeks.org/stream-in-java/
