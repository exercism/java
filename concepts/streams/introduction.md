# Introduction

The `Stream` API, introduced in Java 8, provides a modern, functional way to process data.

A **Stream** is a sequence of elements that supports operations like filtering, mapping, and reducing.  
It allows you to transform and analyze collections without using traditional loops.

Example:
```java
import java.util.*;
import java.util.stream.*;

public class Example {
    public static void main(String[] args) {
        List<String> names = List.of("Arjun", "Riya", "Sam", "Aman");

        names.stream()
             .filter(n -> n.startsWith("A"))
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }
}
