import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.LifecycleManagement;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.*;

// Annotation in order to use @BeforeAll in a non-static method
@TestInstance(LifecycleManagement.Lifecycle.PER_CLASS)
public class EmployeeServiceTest {

    private EmployeeService employeeService;
    private List<Employee> listOfEmployees = new ArrayList<>();

    private List<String> expectedListOfPrintedEmployeesNames = List.of(
        "0 - Tim",
        "1 - Mark",
        "2 - John",
        "3 - No employee found",
        "4 - Jane"
    );

    private List<String> expectedListOfPrintedEmployeesNamesAndDepartments = List.of(
        "0 - Tim - Direction",
        "1 - Mark - Sales",
        "2 - John - Engineering",
        "3 - No employee found",
        "4 - Jane - Sales"
    );

    public List<Employee> getAllTheEmployeesById() {
        return listOfEmployees;
    }

    public Employee getEmployeeById(int employeeId) {
        return listOfEmployees.get(employeeId);
    }

    void initList() {
        listOfEmployees.add(new Employee(0, "Tim", "Direction"));
        listOfEmployees.add(new Employee(1, "Mark", "Sales"));
        listOfEmployees.add(new Employee(2, "John", "Engineering"));
        listOfEmployees.add(null); // Adding a null element
        listOfEmployees.add(new Employee(4, "Jane", "Sales"));
    }

    @BeforeAll
    void setup() {
        initList();
        employeeService = new EmployeeService();
    }

    @Test
    @Tag("task:1")
    @DisplayName("Printing all the employees names")
    void printAllTheEmployeesNames_includingNonExistentOnes() {
        assertThat(employeeService.printAllEmployeesNamesById())
                .isEqualTo(expectedListOfPrintedEmployeesNames);
    }

    @ParameterizedTest
    // @Tag("task:2")
    @MethodSource("employeeTestData")
    @DisplayName("Printing the details of an employee with various IDs")
    void givenAnId_printAnEmployeeNameAndDepartment(int id, String expected) {
        assertThat(employeeService.printEmployeeNameAndDepartmentById(1))
                .isEqualTo(expectedListOfPrintedEmployeesNamesAndDepartments.get(1));
    }

    static Stream<Arguments> employeeTestData() {
        return Stream.of(
                Arguments.of(0), expectedListOfPrintedEmployeesNamesAndDepartments.get(0),
                Arguments.of(1), expectedListOfPrintedEmployeesNamesAndDepartments.get(1),
                Arguments.of(2), expectedListOfPrintedEmployeesNamesAndDepartments.get(2),
                Arguments.of(3), expectedListOfPrintedEmployeesNamesAndDepartments.get(3),
                Arguments.of(4), expectedListOfPrintedEmployeesNamesAndDepartments.get(4)
        );
    }













}
