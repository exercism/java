import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

class EmployeeService {

    //  This list is populated in the tests
    private List<Optional<Employee>> nullableEmployeesList = new ArrayList<>();

    public EmployeeService(List<Optional<Employee>> listOfEmployees) {
        nullableEmployeesList = listOfEmployees;
    }

    public Optional<Employee> getEmployeeById(int employeeId) {
        return nullableEmployeesList
                .stream()
                .flatMap(employee -> employee.stream())
                .filter(employee -> employee.getNullableId()
                        .map(id -> id == employeeId)
                        .orElse(false))
                .findFirst();
    }

    /* I could use IntStream.range(0, nullableEmployeesList.size()) instead of a for loop, but
       understanding the Optional API is difficult enough.
       I do not use method references for the same reason. */
    public String printAllEmployeesNames() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nullableEmployeesList.size(); i++) {
            stringBuilder.append(i).append(" - ");

            nullableEmployeesList.get(i)
                    .flatMap(employee -> employee.getNullableName())
                    .ifPresentOrElse(
                            name -> stringBuilder.append(name).append("\n"),
                            () -> stringBuilder.append("No employee found\n")
                    );
        }
        return stringBuilder.toString();
    }

    public String printEmployeeNameAndDepartmentById(int employeeId) {
        Optional<Employee> employee = getEmployeeById(employeeId);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(employeeId).append(" - ");
        // Handle Optional values
        employee.ifPresentOrElse(
                e -> {
                    e.getNullableName().ifPresent(name ->
                            e.getNullableDepartment().ifPresent(department ->
                                    stringBuilder.append(name).append(" - ").append(department)
                            )
                    );
                },
                () -> stringBuilder.append("No employee found")
        );
        return stringBuilder.toString();
    }

}
