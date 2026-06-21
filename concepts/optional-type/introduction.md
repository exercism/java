# Introduction

## Optional

The **Optional<T>** type was introduced in Java 8 as a way to indicate that a method _may_ return a value.

In other words, there is a chance the method returns "no value" at all.

## Creating an Optional<T> object

Given an object of type Employee, an Optional<Employee> object can be created using the static [of][optional-of-javadoc] method:

```java
Employee employee = new Employee();
Optional<Employee> optionalEmployee = Optional.of(employee);
```

If the employee _may_ be not present, the static [ofNullable][optional-ofNullable-javadoc] method must be used:

```java
Employee nullableEmployee = new Employee();
Optional<Employee> nullableEmployee = Optional.ofNullable(employee);
```

`optionalEmployee` and `nullableEmployee` both are wrappers of an `Employee` object.

## Basic methods

If a value is present, the [isPresent][optional-isPresent-javadoc] method returns true and the [get][optional-get-javadoc] method returns the value.

```java
Employee employee = new Employee("Tim", 45);
Optional<Employee> optionalEmployee = Optional.ofNullable(employee);
boolean isThereAnEmployee = optionalEmployee.isPresent();  // true
Employee employee = optionalEmployee.get();
```

## Usage

In order to throw an exception when the value is not present, the [orElseThrow][optional-orElseThrow-javadoc] method must be used.

```java
public Optional<Employee> getEmployee(String name) {
    // Assume that getEmployeeByName returns an Optional<Employee>
    return getEmployeeByName(name)
           .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
}
```

If a default value must be returned, the [orElse][optional-orElse-javadoc] method can be used.

```java
public Optional<Employee> getEmployee(String name) {
    // Assume that getEmployeeByName returns an Optional<Employee>
    return getEmployeeByName(name)
           .orElse(new Employee("Daniel"));
}
```

Other commonly used method is [ifPresentOrElse][optional-ifPresentOrElse-javadoc], which is used to handle both cases with the same method: the case where the value is present and the case where the value is empty.

```java
public Optional<Employee> getEmployee(String name) {
    // Assume that getEmployeeByName returns an Optional<Employee>
    return getEmployeeByName(name)
           .ifPresentOrElse(
                   employee -> System.out.println(employee.getName()),
                   () -> System.out.println("Employee not found")
           );
}
```

Provided all the invoked methods return Optional objects, many methods can be chained without having to worry about null checking:

```java
public Optional<Integer> getEmployeeAge(String name) {
    Optional<Employee> optionalEmployee = getEmployeeByName(name);
    return getEmployeeByName(name)
               .map(employee -> employee.getAge())
               .orElse("No employee found");
}
```

[optional-of-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Optional.html#of(java.lang.Object)
[optional-ofNullable-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Optional.html#ofNullable(java.lang.Object)
[optional-get-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Optional.html#get()
[optional-isPresent-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Optional.html#isPresent()
[optional-orElse-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Optional.html#orElse(T)
[optional-orElseThrow-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Optional.html#orElseThrow()
[optional-ifPresentOrElse-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Optional.html#ifPresentOrElse(java.util.function.Consumer,java.lang.Runnable)
