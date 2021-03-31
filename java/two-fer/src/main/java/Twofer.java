public class Twofer {
    public String twofer(String name) {
        String other = name == null ? "you": name;
        return "One for " + other + ", one for me.";
    }
}
