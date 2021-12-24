import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LanguageListTest {

    LanguageList languageList = new LanguageList();

    @Test
    public void empty() {
        assertThat(languageList.isEmpty()).isTrue();
    }

    @Test
    public void nonEmpty() {
        languageList.addLanguage("Java");

        assertThat(languageList.isEmpty()).isFalse();
    }

    @Test
    public void addOneLanguage() {
        languageList.addLanguage("Java");

        assertThat(languageList.containsLanguage("Java")).isTrue();
        assertThat(languageList.containsLanguage("Python")).isFalse();
    }

    @Test
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
    public void firstLanguage() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        assertThat(languageList.firstLanguage()).isEqualTo("Java");
    }

    @Test
    public void countThree() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        assertThat(languageList.count()).isEqualTo(3);
    }

    @Test
    public void countEmpty() {
        assertThat(languageList.count()).isEqualTo(0);
    }

    @Test
    public void excitingLanguageListWithJava() {
        languageList.addLanguage("Java");

        assertThat(languageList.isExciting()).isTrue();
    }

    @Test
    public void excitingLanguageListWithKotlin() {
        languageList.addLanguage("Python");
        languageList.addLanguage("Kotlin");

        assertThat(languageList.isExciting()).isTrue();
    }

    @Test
    public void boringLanguageList() {
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");
        languageList.addLanguage("C++");

        assertThat(languageList.isExciting()).isFalse();
    }
}
