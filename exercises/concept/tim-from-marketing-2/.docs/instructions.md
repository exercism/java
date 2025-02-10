# Instructions

In this exercise you will be writing code to print all the names of the factory employees.

Employees have an ID, a name and a department name, like in [tim-from-marketing](/exercises/concept/tim-from-marketing). 
Assume that the ID of the first employee is 1, the ID of the second employee is 2, and so on. If an employee has an ID, the other two fields, name and department name, have valid values.

Two methods are already implemented:

- `getAllTheEmployeesById()` returns an Optional<List<Employee>> object. Notice this method does NOT receive any parameter.
- `getEmployeeById(id)` returns an Optional<Employee> object for the given ID, being Employee the following class:

```java
class Employee {
    private int id;
    private String name;
    private String departmentName;
    // Getters and setters
}
```

## 1.- Print the names of all the employees

Implement the `printAllEmployeesNamesById()` method to print the names of all the employees, together with their id. If the employee does not exist, print "[id] - This employee does not exist".

```java
"1 - Tim"
"2 - Bill"
"3 - Steve"
"4 - This employee does not exist"
"5 - Charlotte"
```

## 2.- Print the name and department of a given employee

Implement the `printEmployeeNameAndDepartmentById(id)` method to print the name and department of a given employee, together with their id. If the employee does not exist, print "[id] - This employee does not exist":

```java
printEmployeeNameAndDepartmentById(1) => "1 - Tim - Marketing"
printEmployeeNameAndDepartmentById(2) => "2 - Bill - Sales"
printEmployeeNameAndDepartmentById(3) => "3 - Steve - Engineering"
printEmployeeNameAndDepartmentById(4) => "4 - This employee does not exist"
printEmployeeNameAndDepartmentById(5) => "5 - Charlotte - Owner"
```

