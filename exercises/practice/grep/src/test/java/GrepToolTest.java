import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GrepToolTest {
    private GrepTool grepTool;

    @Before
    public void setUp() throws IOException {
        List<String> iliadText = Arrays.asList(
            "Achilles sing, O Goddess! Peleus' son;",
            "His wrath pernicious, who ten thousand woes",
            "Caused to Achaia's host, sent many a soul",
            "Illustrious into Ades premature,",
            "And Heroes gave (so stood the will of Jove)",
            "To dogs and to all ravening fowls a prey,",
            "When fierce dispute had separated once",
            "The noble Chief Achilles from the son",
            "Of Atreus, Agamemnon, King of men."
        );
        writeToFile("iliad.txt", iliadText);

        List<String> midsummerNightText = Arrays.asList(
            "I do entreat your grace to pardon me.",
            "I know not by what power I am made bold,",
            "Nor how it may concern my modesty,",
            "In such a presence here to plead my thoughts;",
            "But I beseech your grace that I may know",
            "The worst that may befall me in this case,",
            "If I refuse to wed Demetrius."
        );
        writeToFile("midsummer-night.txt", midsummerNightText);

        List<String> paradiseLostText = Arrays.asList(
            "Of Mans First Disobedience, and the Fruit",
            "Of that Forbidden Tree, whose mortal tast",
            "Brought Death into the World, and all our woe,",
            "With loss of Eden, till one greater Man",
            "Restore us, and regain the blissful Seat,",
            "Sing Heav'nly Muse, that on the secret top",
            "Of Oreb, or of Sinai, didst inspire",
            "That Shepherd, who first taught the chosen Seed"
        );
        writeToFile("paradise-lost.txt", paradiseLostText);

        grepTool = new GrepTool();
    }

    @After
    public void tearDown() throws IOException {
        deleteFile("iliad.txt");
        deleteFile("midsummer-night.txt");
        deleteFile("paradise-lost.txt");
    }

    @Test
    public void oneFileOneMatchNoFlags() {
        String expected = "Of Atreus, Agamemnon, King of men.";

        String actual = grepTool.grep(
            "Agamemnon",
            Collections.emptyList(),
            Collections.singletonList("iliad.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileOneMatchPrintLineNumbersFlag() {
        String expected = "2:Of that Forbidden Tree, whose mortal tast";

        String actual = grepTool.grep(
            "Forbidden",
            Collections.singletonList("-n"),
            Collections.singletonList("paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileOneMatchCaseInsensitiveFlag() {
        String expected = "Of that Forbidden Tree, whose mortal tast";

        String actual = grepTool.grep(
            "FORBIDDEN",
            Collections.singletonList("-i"),
            Collections.singletonList("paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileOneMatchPrintFileNamesFlag() {
        String expected = "paradise-lost.txt";

        String actual = grepTool.grep(
            "Forbidden",
            Collections.singletonList("-l"),
            Collections.singletonList("paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileOneMatchEntireLinesFlag() {
        String expected = "With loss of Eden, till one greater Man";

        String actual = grepTool.grep(
            "With loss of Eden, till one greater Man",
            Collections.singletonList("-x"),
            Collections.singletonList("paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileOneMatchMultipleFlags() {
        String expected = "9:Of Atreus, Agamemnon, King of men.";

        String actual = grepTool.grep(
            "OF ATREUS, Agamemnon, KIng of MEN.",
            Arrays.asList("-n", "-i", "-x"),
            Collections.singletonList("iliad.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileSeveralMatchesNoFlags() {
        String expected = "Nor how it may concern my modesty,\n"
            + "But I beseech your grace that I may know\n"
            + "The worst that may befall me in this case,";

        String actual = grepTool.grep(
            "may",
            Collections.emptyList(),
            Collections.singletonList("midsummer-night.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileSeveralMatchesPrintLineNumbersFlag() {
        String expected = "3:Nor how it may concern my modesty,\n"
            + "5:But I beseech your grace that I may know\n"
            + "6:The worst that may befall me in this case,";

        String actual = grepTool.grep(
            "may",
            Collections.singletonList("-n"),
            Collections.singletonList("midsummer-night.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileSeveralMatchesMatchEntireLineFlag() {
        String expected = "";

        String actual = grepTool.grep(
            "may",
            Collections.singletonList("-x"),
            Collections.singletonList("midsummer-night.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileSeveralMatchesCaseInsensitiveFlag() {
        String expected = "Achilles sing, O Goddess! Peleus' son;\n"
            + "The noble Chief Achilles from the son";

        String actual = grepTool.grep(
            "ACHILLES",
            Collections.singletonList("-i"),
            Collections.singletonList("iliad.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileSeveralMatchesInvertedFlag() {
        String expected = "Brought Death into the World, and all our woe,\n"
            + "With loss of Eden, till one greater Man\n"
            + "Restore us, and regain the blissful Seat,\n"
            + "Sing Heav'nly Muse, that on the secret top\n"
            + "That Shepherd, who first taught the chosen Seed";

        String actual = grepTool.grep(
            "Of",
            Collections.singletonList("-v"),
            Collections.singletonList("paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileNoMatchesVariousFlags() {
        String expected = "";

        String actual = grepTool.grep(
            "Gandalf",
            Arrays.asList("-n", "-l", "-x", "-i"),
            Collections.singletonList("iliad.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileOneMatchFileFlagTakesPrecedenceOverLineFlag() {
        String expected = "iliad.txt";

        String actual = grepTool.grep(
            "ten",
            Arrays.asList("-n", "-l"),
            Collections.singletonList("iliad.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneFileSeveralMatchesInvertedAndMatchEntireLinesFlags() {
        String expected = "Achilles sing, O Goddess! Peleus' son;\n"
            + "His wrath pernicious, who ten thousand woes\n"
            + "Caused to Achaia's host, sent many a soul\n"
            + "And Heroes gave (so stood the will of Jove)\n"
            + "To dogs and to all ravening fowls a prey,\n"
            + "When fierce dispute had separated once\n"
            + "The noble Chief Achilles from the son\n"
            + "Of Atreus, Agamemnon, King of men.";

        String actual = grepTool.grep(
            "Illustrious into Ades premature,",
            Arrays.asList("-x", "-v"),
            Collections.singletonList("iliad.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleFilesOneMatchNoFlags() {
        String expected = "iliad.txt:Of Atreus, Agamemnon, King of men.";

        String actual = grepTool.grep(
            "Agamemnon",
            Collections.emptyList(),
            Arrays.asList("iliad.txt", "midsummer-night.txt", "paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleFilesSeveralMatchesNoFlags() {
        String expected = "midsummer-night.txt:Nor how it may concern my modesty,\n"
            + "midsummer-night.txt:But I beseech your grace that I may know\n"
            + "midsummer-night.txt:The worst that may befall me in this case,";

        String actual = grepTool.grep(
            "may",
            Collections.emptyList(),
            Arrays.asList("iliad.txt", "midsummer-night.txt", "paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleFilesSeveralMatchesPrintLineNumbersFlag() {
        String expected = "midsummer-night.txt:5:But I beseech your grace that I may know\n"
            + "midsummer-night.txt:6:The worst that may befall me in this case,\n"
            + "paradise-lost.txt:2:Of that Forbidden Tree, whose mortal tast\n"
            + "paradise-lost.txt:6:Sing Heav'nly Muse, that on the secret top";

        String actual = grepTool.grep(
            "that",
            Collections.singletonList("-n"),
            Arrays.asList("iliad.txt", "midsummer-night.txt", "paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleFilesOneMatchPrintFileNamesFlag() {
        String expected = "iliad.txt\n"
            + "paradise-lost.txt";

        String actual = grepTool.grep(
            "who",
            Collections.singletonList("-l"),
            Arrays.asList("iliad.txt", "midsummer-night.txt", "paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleFilesSeveralMatchesCaseInsensitiveFlag() {
        String expected = "iliad.txt:Caused to Achaia's host, sent many a soul\n"
            + "iliad.txt:Illustrious into Ades premature,\n"
            + "iliad.txt:And Heroes gave (so stood the will of Jove)\n"
            + "iliad.txt:To dogs and to all ravening fowls a prey,\n"
            + "midsummer-night.txt:I do entreat your grace to pardon me.\n"
            + "midsummer-night.txt:In such a presence here to plead my thoughts;\n"
            + "midsummer-night.txt:If I refuse to wed Demetrius.\n"
            + "paradise-lost.txt:Brought Death into the World, and all our woe,\n"
            + "paradise-lost.txt:Restore us, and regain the blissful Seat,\n"
            + "paradise-lost.txt:Sing Heav'nly Muse, that on the secret top";

        String actual = grepTool.grep(
            "TO",
            Collections.singletonList("-i"),
            Arrays.asList("iliad.txt", "midsummer-night.txt", "paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleFilesSeveralMatchesInvertedFlag() {
        String expected = "iliad.txt:Achilles sing, O Goddess! Peleus' son;\n"
            + "iliad.txt:The noble Chief Achilles from the son\n"
            + "midsummer-night.txt:If I refuse to wed Demetrius.";

        String actual = grepTool.grep(
            "a",
            Collections.singletonList("-v"),
            Arrays.asList("iliad.txt", "midsummer-night.txt", "paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleFilesOneMatchEntireLinesFlag() {
        String expected = "midsummer-night.txt:But I beseech your grace that I may know";

        String actual = grepTool.grep(
            "But I beseech your grace that I may know",
            Collections.singletonList("-x"),
            Arrays.asList("iliad.txt", "midsummer-night.txt", "paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleFilesOneMatchMultipleFlags() {
        String expected = "paradise-lost.txt:4:With loss of Eden, till one greater Man";

        String actual = grepTool.grep(
            "WITH LOSS OF EDEN, TILL ONE GREATER MAN",
            Arrays.asList("-n", "-i", "-x"),
            Arrays.asList("iliad.txt", "midsummer-night.txt", "paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleFilesNoMatchesVariousFlags() {
        String expected = "";

        String actual = grepTool.grep(
            "Frodo",
            Arrays.asList("-n", "-l", "-x", "-i"),
            Arrays.asList("iliad.txt", "midsummer-night.txt", "paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleFilesSeveralMatchesFileFlagTakesPrecedenceOverLineNumberFlag() {
        String expected = "iliad.txt\n"
            + "paradise-lost.txt";

        String actual = grepTool.grep(
            "who",
            Arrays.asList("-n", "-l"),
            Arrays.asList("iliad.txt", "midsummer-night.txt", "paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleFilesSeveralMatchesInvertedAndMatchEntireLinesFlags() {
        String expected = "iliad.txt:Achilles sing, O Goddess! Peleus' son;\n"
            + "iliad.txt:His wrath pernicious, who ten thousand woes\n"
            + "iliad.txt:Caused to Achaia's host, sent many a soul\n"
            + "iliad.txt:And Heroes gave (so stood the will of Jove)\n"
            + "iliad.txt:To dogs and to all ravening fowls a prey,\n"
            + "iliad.txt:When fierce dispute had separated once\n"
            + "iliad.txt:The noble Chief Achilles from the son\n"
            + "iliad.txt:Of Atreus, Agamemnon, King of men.\n"
            + "midsummer-night.txt:I do entreat your grace to pardon me.\n"
            + "midsummer-night.txt:I know not by what power I am made bold,\n"
            + "midsummer-night.txt:Nor how it may concern my modesty,\n"
            + "midsummer-night.txt:In such a presence here to plead my thoughts;\n"
            + "midsummer-night.txt:But I beseech your grace that I may know\n"
            + "midsummer-night.txt:The worst that may befall me in this case,\n"
            + "midsummer-night.txt:If I refuse to wed Demetrius.\n"
            + "paradise-lost.txt:Of Mans First Disobedience, and the Fruit\n"
            + "paradise-lost.txt:Of that Forbidden Tree, whose mortal tast\n"
            + "paradise-lost.txt:Brought Death into the World, and all our woe,\n"
            + "paradise-lost.txt:With loss of Eden, till one greater Man\n"
            + "paradise-lost.txt:Restore us, and regain the blissful Seat,\n"
            + "paradise-lost.txt:Sing Heav'nly Muse, that on the secret top\n"
            + "paradise-lost.txt:Of Oreb, or of Sinai, didst inspire\n"
            + "paradise-lost.txt:That Shepherd, who first taught the chosen Seed";

        String actual = grepTool.grep(
            "Illustrious into Ades premature,",
            Arrays.asList("-x", "-v"),
            Arrays.asList("iliad.txt", "midsummer-night.txt", "paradise-lost.txt")
        );

        assertEquals(expected, actual);
    }

    private void writeToFile(String filename, List<String> contents) throws IOException {
        Path file = Paths.get(filename);
        Files.write(file, contents, Charset.forName("UTF-8"));
    }

    private void deleteFile(String filename) throws IOException {
        Files.deleteIfExists(Paths.get(filename));
    }
}
