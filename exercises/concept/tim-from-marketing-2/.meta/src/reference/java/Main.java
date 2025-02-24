import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Tim", "Marketing"));
        employees.add(new Employee(2, "Joe", "Sales"));
        employees.add(new Employee(3, "Jane", "IT"));
        employees.add(new Employee(4, null, null));

        StringBuilder stringBuilder = new StringBuilder();
        EmployeeService employeeService = new EmployeeService(employees);

        int employeeId = 1;
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        employee.ifPresentOrElse(
                employee1 -> {
                    Optional.ofNullable(employee1.getName())
                            .ifPresentOrElse(name -> System.out.println(stringBuilder.append(employeeId).append(" - ")
                                    .append(employee1.getName()).append(" - ")
                                    .append(employee1.getDepartment()).toString()), () -> {
                                        throw new RuntimeException("No employee found for id: " + employeeId);
                                    });
                },
                () -> {
                    throw new RuntimeException("No employee found for id: " + employeeId);
                });
    }

}

class Employee {
    private final int id;
    private final String name;
    private final String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name)
                && Objects.equals(department, employee.department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

}

class EmployeeService {

    // This list is populated in the tests
    private List<Employee> employeesList = new ArrayList<>();

    public EmployeeService(List<Employee> listOfEmployees) {
        employeesList = listOfEmployees;
    }

    public Optional<Employee> getEmployeeById(int employeeId) {
        for (Employee employee : employeesList) {
            if (Objects.equals(employee.getId(), employeeId)) {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }

    /*
     * public String printEmployeeNameAndDepartmentById(int employeeId) {
     * Optional<Employee> employee = getEmployeeById(employeeId);
     * StringBuilder stringBuilder = new StringBuilder();
     * stringBuilder.append(employeeId).append(" - ");
     * // Handle Optional values
     * employee.ifPresentOrElse(
     * e -> {
     * e.getNullableName().ifPresent(name -> e.getNullableDepartment()
     * .ifPresent(department ->
     * stringBuilder.append(name).append(" - ").append(department)));
     * },
     * () -> stringBuilder.append("No employee found"));
     * return stringBuilder.toString();
     * }
     */

}
