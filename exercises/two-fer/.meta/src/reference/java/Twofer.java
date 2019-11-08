class Twofer {
    String twofer(String name) {
        final String nameToDisplay = name == null || name.isEmpty() ? "you" : name;
        return "One for " + nameToDisplay + ", one for me.";
    }
}
