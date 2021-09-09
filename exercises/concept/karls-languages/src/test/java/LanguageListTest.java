import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class LanguageListTest {

    LanguageList languageList = new LanguageList();

    @Test
    public void empty() {
        assertThat(languageList.isEmpty()).isTrue();
    }

    @Test
    @Ignore("Remove to run test")
    public void nonEmpty() {
        languageList.addLanguage("Java");

        assertThat(languageList.isEmpty()).isFalse();
    }

    @Test
    @Ignore("Remove to run test")
    public void addOneLanguage() {
        languageList.addLanguage("Java");

        assertThat(languageList.containsLanguage("Java")).isTrue();
        assertThat(languageList.containsLanguage("Python")).isFalse();
    }

    @Test
    @Ignore("Remove to run test")
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
    @Ignore("Remove to run test")
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
    @Ignore("Remove to run test")
    public void firstLanguage() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        assertThat(languageList.firstLanguage()).isEqualTo("Java");
    }

    @Test
    @Ignore("Remove to run test")
    public void countThree() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        assertThat(languageList.count()).isEqualTo(3);
    }

    @Test
    @Ignore("Remove to run test")
    public void countEmpty() {
        assertThat(languageList.count()).isEqualTo(0);
    }

    @Test
    @Ignore("Remove to run test")
    public void excitingLanguageListWithJava() {
        languageList.addLanguage("Java");

        assertThat(languageList.isExciting()).isTrue();
    }

    @Test
    @Ignore("Remove to run test")
    public void excitingLanguageListWithKotlin() {
        languageList.addLanguage("Python");
        languageList.addLanguage("Kotlin");

        assertThat(languageList.isExciting()).isTrue();
    }

    @Test
    @Ignore("Remove to run test")
    public void boringLanguageList() {
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");
        languageList.addLanguage("C++");

        assertThat(languageList.isExciting()).isFalse();
    }
}
