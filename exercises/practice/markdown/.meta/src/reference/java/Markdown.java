class Markdown {

    String parse(String markdown) {
        String[] lines = markdown.split("\n");
        StringBuilder result = new StringBuilder();
        boolean activeList = false;

        for (int i = 0; i < lines.length; i++) {
            String lineResult = parseLine(lines[i]);

            if (lineResult.matches("(<li>).*") && !activeList) {
                activeList = true;
                result.append("<ul>");
                result.append(lineResult);
            } else if (!lineResult.matches("(<li>).*") && activeList) {
                activeList = false;
                result.append("</ul>");
                result.append(lineResult);
            } else {
                result.append(lineResult);
            }
        }

        if (activeList) {
            result.append("</ul>");
        }

        return result.toString();
    }

    private String parseLine(String markdown) {
        String result = parseHeader(markdown);

        if (result == null) {
            result = parseListItem(markdown);
        }

        if (result == null) {
            result = parseParagraph(markdown);
        }

        return result;
    }

    private String parseHeader(String markdown) {
        int count = 0;

        for (int i = 0; i < markdown.length(); i++) {
            if (markdown.charAt(i) == '#') {
                count++;
            } else {
                break;
            }
        }

        if (count == 0) {
            return null;
        }

        return wrap(markdown.substring(count + 1), "h" + Integer.toString(count));
    }

    private String parseListItem(String markdown) {
        if (markdown.startsWith("*")) {
            return wrap(parseText(markdown.substring(2)), "li");
        }

        return null;
    }

    private String parseParagraph(String markdown) {
        return wrap(parseText(markdown), "p");
    }

    private String parseText(String markdown) {
        return parseUnderscore(parseDoubleUnderscore(markdown));
    }

    private String parseUnderscore(String markdown) {
        return parseViaRegex(markdown, "_", "em");
    }

    private String parseDoubleUnderscore(String markdown) {
        return parseViaRegex(markdown, "__", "strong");
    }

    private String parseViaRegex(String markdown, String delimiter, String tag) {
        String pattern = delimiter + "(.+)" + delimiter;
        String replacement = wrap("$1", tag);
        return markdown.replaceAll(pattern, replacement);
    }

    private String wrap(String text, String tag) {
        return "<" + tag + ">" + text + "</" + tag + ">";
    }
}
