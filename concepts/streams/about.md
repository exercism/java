# About Streams

Java Streams provide a functional, declarative approach to processing collections of data.

Instead of writing explicit loops, Streams let you build **pipelines** of operations — transforming data step-by-step in a clean, readable way.

---

### Creating Streams
Streams can be created from collections, arrays, or I/O channels:
```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);
Stream<Integer> stream = numbers.stream();
