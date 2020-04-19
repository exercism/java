/**
 * POJO representing an IOU.
 * 
 * If this is in a user's "owed", then the user owes the person with {@link name} this {@link amount}.
 * If this is in a user's "owedBy", then {@link name} owes the user this {@link amount}.
 */
public class Iou {
    public final String name;
    public final int amount;

    public Iou(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}