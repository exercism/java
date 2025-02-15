import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

// Annotation in order to use @BeforeAll in a non-static method
@TestInstance(Lifecycle.PER_CLASS)
public class EmployeeServiceTest {

    private EmployeeService employeeService;
    private List<Optional<Employee>> listOfEmployees = new ArrayList<>();

    private List<String> expectedListOfPrintedEmployeesNames = List.of(
            "0 - Tim\n" + "1 - No employee found\n" + "2 - John\n"
    );

    private List<String> expectedListOfPrintedEmployeesNamesAndDepartments = List.of(
            "0 - Tim - Direction",
            "1 - No employee found",
            "2 - John - Engineering"
    );

    void initList() {
        listOfEmployees.add(Optional.of(new Employee(0, "Tim", "Direction")));
        listOfEmployees.add(Optional.empty()); // Adding empty value.
        listOfEmployees.add(Optional.of(new Employee(2, "John", "Engineering")));
    }

    @BeforeAll
    void setup() {
        initList();
        employeeService = new EmployeeService(listOfEmployees);
    }

    @Test
    @Tag("task:1")
    @DisplayName("Printing all the employees names")
    void printAllTheEmployeesNames_includingNonExistentOnes() {
        String allEmployeesNames = String.join(", ", expectedListOfPrintedEmployeesNames);
        assertThat(employeeService.printAllEmployeesNames())
                .isEqualTo(allEmployeesNames);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Printing the details of the first employee")
    void givenTheFirstId_printAnEmployeeNameAndDepartment() {
        assertThat(employeeService.printEmployeeNameAndDepartmentById(0))
                .isEqualTo(expectedListOfPrintedEmployeesNamesAndDepartments.get(0));
    }

    @Test
    @Tag("task:3")
    @DisplayName("Printing the details of a non-existent employee")
    void givenAnIdWithNoEmployee_printAnEmployeeNameAndDepartment() {
        assertThat(employeeService.printEmployeeNameAndDepartmentById(1))
                .isEqualTo(expectedListOfPrintedEmployeesNamesAndDepartments.get(1));
    }

    @Test
    @Tag("task:4")
    @DisplayName("Printing the details of the last employee")
    void givenTheLastId_printAnEmployeeNameAndDepartment() {
        int lastEmployeeId = listOfEmployees.size() - 1;
        assertThat(employeeService.printEmployeeNameAndDepartmentById(lastEmployeeId))
                .isEqualTo(expectedListOfPrintedEmployeesNamesAndDepartments.get(lastEmployeeId));
    }
}
