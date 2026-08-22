# Instructions

In this exercise you will be writing code to retrieve the factory employees.
Employees have an ID, a name and a department name, like in the [tim-from-marketing](/exercises/concept/tim-from-marketing) exercise.
The first field of an employee is always an integer number, but the name and the department name may be empty or null.
The class constructor receives a parameter of type List<Employee>, which is populated in the tests.
You will be writing two methods: `getEmployeeById(int)` and `getEmployeeDetailsById(int)`.

## 1. Get an employee by ID

Implement the `getEmployeeById(int)` method so that it returns an Optional<Employee> object.

If the employee does not exist, returns an empty Optional instance.

## 2. Return the name and department of a given employee in a certain format

Implement the `getEmployeeDetailsById(int)` method to return a string containing the id, the name and the department of a given employee:

```java
getEmployeeDetailsById(1) => "1 - Tim - Marketing"
getEmployeeDetailsById(3) => "3 - Steve - Engineering"
```

If the employee does not exist or is null, it returns `No employee found for id: [id]`.
