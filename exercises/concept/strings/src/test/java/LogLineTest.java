import org.junit.Test;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.*;

public class LogLineTest {
    @Test
    public void error_message() {
        assertThat(LogLine.message("[ERROR]: Stack overflow")).isEqualTo("Stack overflow");
    }

    @Ignore("Remove to run test")
    @Test
    public void warning_message() {
        assertThat(LogLine.message("[WARNING]: Disk almost full")).isEqualTo("Disk almost full");
    }

    @Ignore("Remove to run test")
    @Test
    public void info_message() {
        assertThat(LogLine.message("[INFO]: File moved")).isEqualTo("File moved");
    }

    @Ignore("Remove to run test")
    @Test
    public void message_with_leading_and_trailing_white_space() {
        assertThat(LogLine.message("[WARNING]:   \tTimezone not set  \r\n")).isEqualTo("Timezone not set");
    }

    @Ignore("Remove to run test")
    @Test
    public void error_log_level() {
        assertThat(LogLine.logLevel("[ERROR]: Disk full")).isEqualTo("error");
    }

    @Ignore("Remove to run test")
    @Test
    public void warning_log_level() {
        assertThat(LogLine.logLevel("[WARNING]: Unsafe password")).isEqualTo("warning");
    }

    @Ignore("Remove to run test")
    @Test
    public void info_log_level() {
        assertThat(LogLine.logLevel("[INFO]: Timezone changed")).isEqualTo("info");
    }

    @Ignore("Remove to run test")
    @Test
    public void error_reformat() {
        assertThat(LogLine.reformat("[ERROR]: Segmentation fault"))
            .isEqualTo("Segmentation fault (error)");
    }

    @Ignore("Remove to run test")
    @Test
    public void warning_reformat() {
        assertThat(LogLine.reformat("[WARNING]: Decreased performance"))
            .isEqualTo("Decreased performance (warning)");        
    }

    @Ignore("Remove to run test")
    @Test
    public void info_reformat() {
        assertThat(LogLine.reformat("[INFO]: Disk defragmented"))
            .isEqualTo("Disk defragmented (info)");        
    }

    @Ignore("Remove to run test")
    @Test
    public void reformat_with_leading_and_trailing_white_space() {
        assertThat(LogLine.reformat("[ERROR]: \t Corrupt disk\t \t \r\n"))
            .isEqualTo("Corrupt disk (error)");        
    }
}
