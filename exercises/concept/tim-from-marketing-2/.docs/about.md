# ???

The **Optional<T>** type was introduced in Java 8 as a way to indicate that a method _may_ return a value.

Before Java 8, developers had to implement null checks:

```java
public Employee getEmployee(String name) {
    // Assume that getEmployeeByName retrieves an Employee from a database
    Employee employee = getEmployeeByName(name);
    if (employee != null) {
        return employee;
    } else {
        throw new IllegalArgumentException("Employee not found");
    }
}
```

It is important to understand that the Optional API does not eliminate the null checking,
but it defers it until the end of a series of methods, as long as all those methods return an optional object.

TBD: Rephrase this last paragraph.

The Optional type is mainly used as returned type. Using it as a parameter type or field type is less common and
not recommended, as explained by one well-known Java language architect in [this SO answer](https://stackoverflow.com/questions/26327957/should-java-8-getters-return-optional-type).
