# Introduction

## Optional

## Introduction

The Optional<T> type was introduced in Java 8 as a way to indicate that a method will return an object of type T or a null value. It is present in type signatures of many core Java methods. 

Before Java 8, developers had to implement null checks:

```java
public Employee getEmployee(String name) {
    // Assume that getEmployeeByName retrieves an Employee from a data base
    Employee employee = getEmployeeByName(name);
    if (employee != null) {
        return employee;
    } else {
        return throw new IllegalArgumentException("Employee not found");
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

If a default value must be returned, the `orElse` method can be used.

```java
public Optional<Employee> getEmployee(String name) {
    // Assume that getEmployeeByName returns an Optional<Employee>
    return getEmployeeByName(name)
           .orElse(new Employee("Daniel"));
}
```

Provided all the invoked methods return Optional objects, many methods can be chained without having to worry about null checking:

```java
public Optional<Integer> getEmployeeAge(String name) {
    Optional<Employee> optionalEmployee = getEmployeeByName(name);
    return getEmployeeByName(name)
               .map(Employee::getAge)
               .orElse(0);
}
```

It is important to understand that the Optional API does not eliminate the null values. It defers the null checking until the end of a series of methods, as long as all those methods return an optional object. 

