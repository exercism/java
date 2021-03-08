import org.junit.Test;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.*;

public class LogLevelsTest {
    @Test
    public void error_message() {
        assertThat(LogLevels.message("[ERROR]: Stack overflow")).isEqualTo("Stack overflow");
    }

    @Ignore("Remove to run test")
    @Test
    public void warning_message() {
        assertThat(LogLevels.message("[WARNING]: Disk almost full")).isEqualTo("Disk almost full");
    }

    @Ignore("Remove to run test")
    @Test
    public void info_message() {
        assertThat(LogLevels.message("[INFO]: File moved")).isEqualTo("File moved");
    }

    @Ignore("Remove to run test")
    @Test
    public void message_with_leading_and_trailing_white_space() {
        assertThat(LogLevels.message("[WARNING]:   \tTimezone not set  \r\n")).isEqualTo("Timezone not set");
    }

    @Ignore("Remove to run test")
    @Test
    public void error_log_level() {
        assertThat(LogLevels.logLevel("[ERROR]: Disk full")).isEqualTo("error");
    }

    @Ignore("Remove to run test")
    @Test
    public void warning_log_level() {
        assertThat(LogLevels.logLevel("[WARNING]: Unsafe password")).isEqualTo("warning");
    }

    @Ignore("Remove to run test")
    @Test
    public void info_log_level() {
        assertThat(LogLevels.logLevel("[INFO]: Timezone changed")).isEqualTo("info");
    }

    @Ignore("Remove to run test")
    @Test
    public void error_reformat() {
        assertThat(LogLevels.reformat("[ERROR]: Segmentation fault"))
            .isEqualTo("Segmentation fault (error)");
    }

    @Ignore("Remove to run test")
    @Test
    public void warning_reformat() {
        assertThat(LogLevels.reformat("[WARNING]: Decreased performance"))
            .isEqualTo("Decreased performance (warning)");        
    }

    @Ignore("Remove to run test")
    @Test
    public void info_reformat() {
        assertThat(LogLevels.reformat("[INFO]: Disk defragmented"))
            .isEqualTo("Disk defragmented (info)");        
    }

    @Ignore("Remove to run test")
    @Test
    public void reformat_with_leading_and_trailing_white_space() {
        assertThat(LogLevels.reformat("[ERROR]: \t Corrupt disk\t \t \r\n"))
            .isEqualTo("Corrupt disk (error)");        
    }
}
