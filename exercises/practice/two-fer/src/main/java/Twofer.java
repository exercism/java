public class Twofer {
    public String twofer(String name) {
        name = (name == null) ? name = "you" : name;
        String twoferPhrase = "One for " + name + ", one for me.";
        return twoferPhrase;
    }
}
