import java.util.ArrayList;
import java.util.List;
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

    public String printAllEmployeesNames() {
        throw new UnsupportedOperationException(
        "Please implement the EmployeeService.printAllEmployeesNames() method");
    }

    public String printEmployeeNameAndDepartmentById(int employeeId) {
        throw new UnsupportedOperationException(
        "Please implement the EmployeeService.printEmployeeNameAndDepartmentById(id) method");
    }

}
