# Instructions

In this exercise you will be writing code to print all the names of the factory employees.
Employees have an ID, a name and a department name, like in the [tim-from-marketing](/exercises/concept/tim-from-marketing) exercise. 
Assume that the ID of the first employee is 0, the ID of the second employee is 1, and so on. The three fields of an employee may be empty, that's why they are declared as Optional<T> types.
The class constructor receives a parameter of type List<Optional<Employee>>, which is populated in the tests.

## 1.- Print the names of all the employees
Implement the `printAllEmployeesNames()` method to print the names of all the employees, together with their id. If the employee does not exist, print "[id] - No employee found".

```java
"
1 - Tim
2 - Bill
3 - Steve
4 - No employee found
5 - Charlotte
"
```

## 2.- Print the name and department of a given employee

Implement the `printEmployeeNameAndDepartmentById(id)` method to print the name and department of a given employee, together with their id. If the employee does not exist, print "[id] - No employee found". You will have to call the method `getEmployeeById(int employeeId)`, which returns an Optional<Employee> and it's already defined.

```java
printEmployeeNameAndDepartmentById(1) => "1 - Tim - Marketing"
printEmployeeNameAndDepartmentById(3) => "3 - Steve - Engineering"
printEmployeeNameAndDepartmentById(4) => "4 - This employee does not exist"
```
