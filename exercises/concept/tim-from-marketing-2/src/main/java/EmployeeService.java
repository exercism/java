import java.util.List;
import java.util.Optional;
import java.util.stream.*;

class EmployeeService {

    /*
     The getAllTheEmployeesById and getEmployeeById methods are already implemented.
     */

    // Convert the list of employees to a list of Optional<Employee>
    public List<Optional<Employee>> getAllTheEmployeesById() {
        return getAllTheEmployeesById()
                .stream()
                .map(employee -> Optional.ofNullable(employee))
                .collect(Collectors.toList());
    }
    
    public Optional<Employee> getEmployeeById(int id) {
        return Optional.ofNullable(getEmployeeById(employeeId));
    }


    public String printAllEmployeesNamesById() {
        throw new UnsupportedOperationException("Please implement the EmployeeService.printAllEmployeesNamesById() method");
    }

    public String printEmployeeNameAndDepartmentById(int employeeId) {
        throw new UnsupportedOperationException("Please implement the EmployeeService.printEmployeeNameAndDepartmentById(id) method");
    }


}
