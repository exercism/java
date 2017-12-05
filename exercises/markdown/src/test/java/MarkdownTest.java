import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarkdownTest {

    private Markdown markdown;

    @Before
    public void setup() {
        markdown = new Markdown();
    }

    @Test
    public void normalTextAsAParagraph() {
        String input = "This will be a paragraph";
        String expected = "<p>This will be a paragraph</p>";

        assertEquals(expected, markdown.parse(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void italics() {
        String input = "_This will be italic_";
        String expected = "<p><em>This will be italic</em></p>";

        assertEquals(expected, markdown.parse(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void boldText() {
        String input = "__This will be bold__";
        String expected = "<p><strong>This will be bold</strong></p>";

        assertEquals(expected, markdown.parse(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void normalItalicsAndBoldText() {
        String input = "This will _be_ __mixed__";
        String expected = "<p>This will <em>be</em> <strong>mixed</strong></p>";

        assertEquals(expected, markdown.parse(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void withH1HeaderLevel() {
        String input = "# This will be an h1";
        String expected = "<h1>This will be an h1</h1>";

        assertEquals(expected, markdown.parse(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void withH2HeaderLevel() {
        String input = "## This will be an h2";
        String expected = "<h2>This will be an h2</h2>";

        assertEquals(expected, markdown.parse(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void withH6HeaderLevel() {
        String input = "###### This will be an h6";
        String expected = "<h6>This will be an h6</h6>";

        assertEquals(expected, markdown.parse(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void unorderedLists() {
        String input = "* Item 1\n* Item 2";
        String expected = "<ul><li>Item 1</li><li>Item 2</li></ul>";

        assertEquals(expected, markdown.parse(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void aLittleBitOfEverything() {
        String input = "# Header!\n* __Bold Item__\n* _Italic Item_";
        String expected = "<h1>Header!</h1><ul><li><strong>Bold Item</strong></li><li><em>Italic Item</em></li></ul>";

        assertEquals(expected, markdown.parse(input));
    }
}