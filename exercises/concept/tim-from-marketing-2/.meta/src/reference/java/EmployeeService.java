import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.*;


class EmployeeService {
  
    public List<Optional<Employee>> getAllTheEmployeesById() {
        return getAllTheEmployeesById()
        .stream()
        .map(employee -> Optional.ofNullable(employee))
        .collect(Collectors.toList());
    }

    public Optional<Employee> getEmployeeById(int employeeId) {
       /* Solution using Streams
        
        return getAllTheEmployeesById(employeesList).stream()
                                     .filter(employee -> employee.getId() == id)
                                     .orElse("Employee not found");
        */

        return Optional.ofNullable(getEmployeeById(employeeId));
    }

    public String printAllEmployeesNamesById() {
        List<Optional<Employee>> nullableEmployeesList = getAllTheEmployeesById();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nullableEmployeesList.size(); i++) {
            stringBuilder.append(i).append(" - ");

            nullableEmployeesList.get(i)
                .flatMap(employee -> employee.getName())
                .ifPresentOrElse(
                    name -> stringBuilder.append(name).append("\n"),
                    () -> stringBuilder.append("No employee found\n")
                );
        }
        return stringBuilder.toString();
    }

    public String printEmployeeNameAndDepartmentById(int employeeId) {

        var employee = getEmployeeById(employeeId);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(employeeId).append(" - ");
        employee.ifPresentOrElse(
            e -> {
                // Handle Optional values
                e.getName().ifPresentOrElse(
                    name -> stringBuilder.append(name).append(" - "),
                    () -> {}
                );
                e.getDepartment().ifPresentOrElse(
                    department -> stringBuilder.append(department),
                    () -> {}
                );
            },
            () -> stringBuilder.append("No employee found")
        );
        return stringBuilder.toString();
    }       

}

