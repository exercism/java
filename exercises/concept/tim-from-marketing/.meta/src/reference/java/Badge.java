public class Badge {

    public String print(Integer id, String name, String department) {

        String worksAt;

        if (department == null) {
            worksAt = "OWNER";
        } else {
            worksAt = department.toUpperCase();
        }

        if (id == null) {
            return name + " - " + worksAt;
        }

        return "[" + id + "] - " + name + " - " + worksAt;
    }

}
