import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        var employeeService = new EmployeeService();
        System.out.println(employeeService.printAllEmployeesNamesById());
        System.out.println(employeeService.printEmployeeNameAndDepartmentById(1));
        System.out.println(employeeService.printEmployeeNameAndDepartmentById(2));
        System.out.println(employeeService.printEmployeeNameAndDepartmentById(3));
        System.out.println(employeeService.printEmployeeNameAndDepartmentById(4));
    }
}

class EmployeeService {
  
    private Utils utils = new Utils();

    public List<Optional<Employee>> getAllTheEmployeesById() {
        return utils.getAllTheEmployeesById()
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

        return Optional.ofNullable(utils.getEmployeeById(employeeId));
    }

    public String printAllEmployeesNamesById() {
        List<Optional<Employee>> nullableEmployeesList = getAllTheEmployeesById();
        // var employee = new Employee();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nullableEmployeesList.size(); i++) {
            stringBuilder.append(i).append(" - ");

            nullableEmployeesList.get(i)
                .flatMap(employee -> employee.getName())
                // .map(nullableEmployee -> nullableEmployee.get())  // Compile error
                .ifPresentOrElse(
                    name -> stringBuilder.append(name).append("\n"),
                    () -> stringBuilder.append("No employee found\n")
                );
              //  .ifPresent(name -> stringBuilder.append(name))
              //  .orElse("No employee found");    // compile error
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

class Utils {

    private List<Employee> listOfEmployees = new ArrayList<>();
    // List.of(   // Immutable lists do not allow null elements
{ 
    listOfEmployees.add(new Employee(0, "Tim", "Direction"));
    listOfEmployees.add(new Employee(1, "Mark", "Sales"));
    listOfEmployees.add(new Employee(2, "John", "Engineering"));
    listOfEmployees.add(null); // Adding a null element
    listOfEmployees.add(new Employee(4, "Jane", "Sales"));
}

    public List<Employee> getAllTheEmployeesById() {
        return listOfEmployees;
    }

    public Employee getEmployeeById(int employeeId) {
        return listOfEmployees.get(employeeId);
    }
}


class Employee {
    private final int id;  // It can't be final due to the empty constructor
    private final String name;
    private final String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Optional<Integer> getId() {
        return Optional.ofNullable(id); 
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<String> getDepartment() {
        return Optional.ofNullable(department);
    }
}
