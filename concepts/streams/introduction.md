# Introduction to Streams

**Streams** are part of Java’s functional programming toolkit. They allow you to process collections in a declarative style—focusing on *what* to do, not *how* to do it.

You can create streams from collections like `List`, `Set`, or arrays, and then apply operations like `filter`, `map`, and `reduce` to transform or analyze the data.

## Examples

### Filtering a List
```java
List<String> names = List.of("Akash", "James", "Charles");
List<String> filtered = names.stream()
                             .filter(name -> name.startsWith("A"))
                             .collect(Collectors.toList());
// filtered is ["Akash"]
