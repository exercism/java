# About the Optional Type

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

With the Optional API, the code above can be simplified to:

```java
public Optional<Employee> getEmployee(String name) {
    // Assume that getEmployeeByName returns an Optional<Employee>
    return getEmployeeByName(name)
           .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
}
```

## Usage with the Stream API

The Optional API is more useful when many methods are chained and each method returns an Optional<T> object.

```java
List<Optional<Employee>> employees = new ArrayList<>();
employees.add(getEmployee("Tim"));
employees.add(getEmployee("Bob"));
employees.add(getEmployee("Alice"));
```

```java
public List<Optional<Employee>> getEmployeesInTheirTwenties(){
    return employees.stream()
                   .filter(Optional::isPresent)
                   .map(Optional::get)
                   .filter(employee -> employee.getAge() >= 20 && employee.getAge() < 30)
                   .collect(Collectors.toList());
}
```

It is important to understand that the Optional API does not eliminate the null checking,
but it defers it until the end of a series of methods, as long as all those methods return an optional object.

## Recommended usage

The Optional type is mainly used as returned type. Using it as a parameter type or field type is less common and
not recommended, as explained by one well-known Java language architect in [this SO answer](https://stackoverflow.com/questions/26327957/should-java-8-getters-return-optional-type)

The official documentation says:
> Optional is primarily intended for use as a method return type where there is a clear need to represent "no result," and where using null is likely to cause errors. A variable whose type is Optional should never itself be null; it should always point to an Optional instance.
