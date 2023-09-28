import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LogLevelsTest {
    @Test
    @Tag("task:1")
    @DisplayName("The message method returns the log line's message of an error log")
    public void error_message() {
        assertThat(LogLevels.message("[ERROR]: Stack overflow")).isEqualTo("Stack overflow");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The message method returns the log line's message of a warning log")
    public void warning_message() {
        assertThat(LogLevels.message("[WARNING]: Disk almost full")).isEqualTo("Disk almost full");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The message method returns the log line's message of an info log")
    public void info_message() {
        assertThat(LogLevels.message("[INFO]: File moved")).isEqualTo("File moved");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The message method returns the log line's message after removing leading and trailing spaces")
    public void message_with_leading_and_trailing_white_space() {
        assertThat(LogLevels.message("[WARNING]:   \tTimezone not set  \r\n")).isEqualTo("Timezone not set");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The logLevel method returns the log level of an error log line")
    public void error_log_level() {
        assertThat(LogLevels.logLevel("[ERROR]: Disk full")).isEqualTo("error");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The logLevel method returns the log level of a warning log line")
    public void warning_log_level() {
        assertThat(LogLevels.logLevel("[WARNING]: Unsafe password")).isEqualTo("warning");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The logLevel method returns the log level of an info log line")
    public void info_log_level() {
        assertThat(LogLevels.logLevel("[INFO]: Timezone changed")).isEqualTo("info");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The reformat method correctly reformats an error log line")
    public void error_reformat() {
        assertThat(LogLevels.reformat("[ERROR]: Segmentation fault"))
            .isEqualTo("Segmentation fault (error)");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The reformat method correctly reformats a warning log line")
    public void warning_reformat() {
        assertThat(LogLevels.reformat("[WARNING]: Decreased performance"))
            .isEqualTo("Decreased performance (warning)");        
    }

    @Test
    @Tag("task:3")
    @DisplayName("The reformat method correctly reformats an info log line")
    public void info_reformat() {
        assertThat(LogLevels.reformat("[INFO]: Disk defragmented"))
            .isEqualTo("Disk defragmented (info)");        
    }

    @Test
    @Tag("task:3")
    @DisplayName("The reformat method correctly reformats an error log line removing spaces")
    public void reformat_with_leading_and_trailing_white_space() {
        assertThat(LogLevels.reformat("[ERROR]: \t Corrupt disk\t \t \r\n"))
            .isEqualTo("Corrupt disk (error)");        
    }
}
