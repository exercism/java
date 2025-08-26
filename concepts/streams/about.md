# About Streams

**Streams** are a functional abstraction for processing sequences of data in Java.
Unlike collections like [`List`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html), a [`Stream`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html) does not store elements—it describes a pipeline of operations to transform or compute data.

Streams are typically created from collections, arrays, or manually using `Stream.of(...)`.

For example:

```java
Stream<String> emptyStream = Stream.of();
Stream<Integer> singleInteger = Stream.of(1);
Stream<Boolean> threeBooleans = Stream.of(true, false, true);
Stream<Object> mixedTypes = Stream.of("hello", 1, true); // allowed in Stream<Object>
```


[Java Stream API Overview]:https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/package-summary.html
[Collectors Class]:https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/Collectors.html
[Stream Interface Documentation]:https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/Stream.html
[Stream Operations Explained]:https://www.geeksforgeeks.org/stream-in-java/
