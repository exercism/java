import java.util.List;
import java.util.Optional;
import java.util.Objects;

class EmployeeDatabase {

    // This list is populated in the tests
    private List<Employee> employeesList;

    public EmployeeDatabase(List<Employee> listOfEmployees) {
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

    public String getEmployeeDetailsById(int employeeId) {
        Optional<Employee> nullableEmployee = getEmployeeById(employeeId);
        StringBuilder stringBuilder = new StringBuilder();
        nullableEmployee.ifPresentOrElse(
                employee1 -> {
                    Optional.ofNullable(employee1.getName())
                            .ifPresentOrElse(name -> stringBuilder.append(employeeId).append(" - ")
                                    .append(employee1.getName()).append(" - ")
                                    .append(employee1.getDepartment()),
                            () -> {
                                stringBuilder.append("No employee found for id: ").append(employeeId);
                            });
                },
                () -> {
                    stringBuilder.append("That id does not exist: ").append(employeeId);
                });
        return stringBuilder.toString();
    }
}






