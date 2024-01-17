import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarkdownTest {

    private Markdown markdown;

    @BeforeEach
    public void setup() {
        markdown = new Markdown();
    }

    @Test
    public void normalTextAsAParagraph() {
        String input = "This will be a paragraph";
        String expected = "<p>This will be a paragraph</p>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void italics() {
        String input = "_This will be italic_";
        String expected = "<p><em>This will be italic</em></p>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void boldText() {
        String input = "__This will be bold__";
        String expected = "<p><strong>This will be bold</strong></p>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void normalItalicsAndBoldText() {
        String input = "This will _be_ __mixed__";
        String expected = "<p>This will <em>be</em> <strong>mixed</strong></p>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void withH1HeaderLevel() {
        String input = "# This will be an h1";
        String expected = "<h1>This will be an h1</h1>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void withH2HeaderLevel() {
        String input = "## This will be an h2";
        String expected = "<h2>This will be an h2</h2>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void withH3HeaderLevel() {
        String input = "### This will be an h3";
        String expected = "<h3>This will be an h3</h3>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void withH4HeaderLevel() {
        String input = "#### This will be an h4";
        String expected = "<h4>This will be an h4</h4>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void withH5HeaderLevel() {
        String input = "##### This will be an h5";
        String expected = "<h5>This will be an h5</h5>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void withH6HeaderLevel() {
        String input = "###### This will be an h6";
        String expected = "<h6>This will be an h6</h6>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void h7HeaderLevelIsAParagraph() {
        String input = "####### This will not be an h7";
        String expected = "<p>####### This will not be an h7</p>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void unorderedLists() {
        String input = "* Item 1\n* Item 2";
        String expected = "<ul><li>Item 1</li><li>Item 2</li></ul>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void aLittleBitOfEverything() {
        String input = "# Header!\n* __Bold Item__\n* _Italic Item_";
        String expected = "<h1>Header!</h1><ul><li><strong>Bold Item</strong></li><li><em>Italic Item</em></li></ul>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void markdownSymbolsInTheHeaderShouldNotBeInterpreted() {
        String input = "# This is a header with # and * in the text";
        String expected = "<h1>This is a header with # and * in the text</h1>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void markdownSymbolsInTheListItemTextShouldNotBeInterpreted() {
        String input = "* Item 1 with a # in the text\n* Item 2 with * in the text";
        String expected = "<ul><li>Item 1 with a # in the text</li><li>Item 2 with * in the text</li></ul>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void markdownSymbolsInTheParagraphTextShouldNotBeInterpreted() {
        String input = "This is a paragraph with # and * in the text";
        String expected = "<p>This is a paragraph with # and * in the text</p>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void markdownUnorderedListsCloseProperlyWithPrecedingAndFollowingLines() {
        String input = "# Start a list\n* Item 1\n* Item 2\nEnd a list";
        String expected = "<h1>Start a list</h1><ul><li>Item 1</li><li>Item 2</li></ul><p>End a list</p>";

        assertThat(markdown.parse(input)).isEqualTo(expected);
    }

}
