class MicroBlog {
    public static String truncate(String input) {
        return input.codePoints()
            .limit(5)
            .collect(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append)
            .toString();
    }
}
