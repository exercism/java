import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

/** POJO representing a User in the database. */
public class User {
    private final String name;
    private final List<Iou> owes;
    private final List<Iou> owedBy;

    User(String name, List<Iou> owes, List<Iou> owedBy) {
        this.name = name;
        this.owes = new ArrayList<>(owes);
        this.owedBy = new ArrayList<>(owedBy);
    }

    public String name() {
        return name;
    }

    /** IOUs this user owes to other users. */
    public List<Iou> owes() {
        return unmodifiableList(owes);
    }

    /** IOUs other users owe to this user. */
    public List<Iou> owedBy() {
        return unmodifiableList(owedBy);
    }
}