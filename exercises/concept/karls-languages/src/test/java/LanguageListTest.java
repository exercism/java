import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LanguageListTest {

    LanguageList languageList = new LanguageList();

    @Test
    @Tag("task:1")
    @DisplayName("The isEmpty method returns true when no language was added to the list")
    public void empty() {
        assertThat(languageList.isEmpty()).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The addLanguage method correctly adds a language to the list so that list is no more empty")
    public void nonEmpty() {
        languageList.addLanguage("Java");

        assertThat(languageList.isEmpty()).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The removeLanguage method correctly removes a language from the list")
    public void removeLanguage() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        languageList.removeLanguage("Python");

        assertThat(languageList.containsLanguage("Java")).isTrue();
        assertThat(languageList.containsLanguage("Python")).isFalse();
        assertThat(languageList.containsLanguage("Ruby")).isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstLanguage method correctly retrieves the first language that was added to the list")
    public void firstLanguage() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        assertThat(languageList.firstLanguage()).isEqualTo("Java");
    }

    @Test
    @Tag("task:5")
    @DisplayName("The count method returns the correct number of languages that were added to the list")
    public void countThree() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        assertThat(languageList.count()).isEqualTo(3);
    }

    @Test
    @Tag("task:5")
    @DisplayName("The count method returns 0 in case no language was added to the list")
    public void countEmpty() {
        assertThat(languageList.count()).isEqualTo(0);
    }

    @Test
    @Tag("task:6")
    @DisplayName("The containsLanguage method returns the correct booleans after adding a language to the list")
    public void addOneLanguage() {
        languageList.addLanguage("Java");

        assertThat(languageList.containsLanguage("Java")).isTrue();
        assertThat(languageList.containsLanguage("Python")).isFalse();
    }

    @Test
    @Tag("task:6")
    @DisplayName("The containsLanguage method returns the correct booleans after adding several languages to the list")
    public void addMultipleLanguages() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Ruby");
        languageList.addLanguage("C++");

        assertThat(languageList.containsLanguage("Java")).isTrue();
        assertThat(languageList.containsLanguage("Ruby")).isTrue();
        assertThat(languageList.containsLanguage("C++")).isTrue();
        assertThat(languageList.containsLanguage("Python")).isFalse();
    }

    @Test
    @Tag("task:7")
    @DisplayName("The isExciting method returns true after Java was added to the list")
    public void excitingLanguageListWithJava() {
        languageList.addLanguage("Java");

        assertThat(languageList.isExciting()).isTrue();
    }

    @Test
    @Tag("task:7")
    @DisplayName("The isExciting method returns true after Kotlin was added to the list")
    public void excitingLanguageListWithKotlin() {
        languageList.addLanguage("Python");
        languageList.addLanguage("Kotlin");

        assertThat(languageList.isExciting()).isTrue();
    }

    @Test
    @Tag("task:7")
    @DisplayName("The isExciting method returns false when neither Java nor Kotlin were added to the list")
    public void boringLanguageList() {
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");
        languageList.addLanguage("C++");

        assertThat(languageList.isExciting()).isFalse();
    }
}
