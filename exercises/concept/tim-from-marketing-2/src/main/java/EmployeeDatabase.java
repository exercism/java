import java.util.List;
import java.util.Objects;
import java.util.Optional;

class EmployeeDatabase {

    private List<Employee> employeesList;

    public EmployeeDatabase(List<Employee> listOfEmployees) {
        //  This list is populated in the tests
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
                    stringBuilder.append("No employee found for id: ").append(employeeId);
                });
        return stringBuilder.toString();
    }

//    public Optional<Employee> getEmployeeById(int employeeId) {
//        throw new UnsupportedOperationException("Please implement this method");
//    }
//
//    public String getEmployeeDetailsById(int employeeId) {
//        throw new UnsupportedOperationException("Please implement this method");
//    }

}
