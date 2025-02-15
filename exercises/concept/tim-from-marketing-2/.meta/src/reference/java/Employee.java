import java.util.Objects;
import java.util.Optional;

class Employee {
    private final int id;  
    private final String name;
    private final String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Optional<Integer> getNullableId() {
        return Optional.ofNullable(id);
    }

    public Optional<String> getNullableName() {
        return Optional.ofNullable(name);
    }

    public Optional<String> getNullableDepartment() {
        return Optional.ofNullable(department);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department);
    }
}
