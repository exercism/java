class Employee {
    private final int id;  
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
