import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class SwiftSchedulingTest {
    @Test
    @DisplayName("NOW translates to two hours later")
    void testNowAtNineAm() {
        LocalDateTime meetingStart = LocalDateTime.parse("2012-02-13T09:00:00");
        LocalDateTime expected = LocalDateTime.parse("2012-02-13T11:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "NOW");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ASAP before one in the afternoon translates to today at five in the afternoon")
    void testAsapBeforeOnePm() {
        LocalDateTime meetingStart = LocalDateTime.parse("1999-06-03T09:45:00");
        LocalDateTime expected = LocalDateTime.parse("1999-06-03T17:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "ASAP");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ASAP at one in the afternoon translates to tomorrow at one in the afternoon")
    void testAsapAtOnePm() {
        LocalDateTime meetingStart = LocalDateTime.parse("2008-12-21T13:00:00");
        LocalDateTime expected = LocalDateTime.parse("2008-12-22T13:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "ASAP");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ASAP after one in the afternoon translates to tomorrow at one in the afternoon")
    void testAsapAfterOnePm() {
        LocalDateTime meetingStart = LocalDateTime.parse("2008-12-21T14:50:00");
        LocalDateTime expected = LocalDateTime.parse("2008-12-22T13:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "ASAP");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("EOW on Monday translates to Friday at five in the afternoon")
    void testEowOnMonday() {
        LocalDateTime meetingStart = LocalDateTime.parse("2025-02-03T16:00:00");
        LocalDateTime expected = LocalDateTime.parse("2025-02-07T17:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "EOW");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("EOW on Tuesday translates to Friday at five in the afternoon")
    void testEowOnTuesday() {
        LocalDateTime meetingStart = LocalDateTime.parse("1997-04-29T10:50:00");
        LocalDateTime expected = LocalDateTime.parse("1997-05-02T17:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "EOW");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("EOW on Wednesday translates to Friday at five in the afternoon")
    void testEowOnWednesday() {
        LocalDateTime meetingStart = LocalDateTime.parse("2005-09-14T11:00:00");
        LocalDateTime expected = LocalDateTime.parse("2005-09-16T17:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "EOW");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("EOW on Thursday translates to Sunday at eight in the evening")
    void testEowOnThursday() {
        LocalDateTime meetingStart = LocalDateTime.parse("2011-05-19T08:30:00");
        LocalDateTime expected = LocalDateTime.parse("2011-05-22T20:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "EOW");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("EOW on Friday translates to Sunday at eight in the evening")
    void testEowOnFriday() {
        LocalDateTime meetingStart = LocalDateTime.parse("2022-08-05T14:00:00");
        LocalDateTime expected = LocalDateTime.parse("2022-08-07T20:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "EOW");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("EOW translates to leap day")
    void testEowDuringLeapYear() {
        LocalDateTime meetingStart = LocalDateTime.parse("2008-02-25T10:30:00");
        LocalDateTime expected = LocalDateTime.parse("2008-02-29T17:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "EOW");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName(
        "2M before the second month of this year translates to the first workday of the second month of this year"
    )
    void test2MInJanuary() {
        LocalDateTime meetingStart = LocalDateTime.parse("2007-01-02T14:15:00");
        LocalDateTime expected = LocalDateTime.parse("2007-02-01T08:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "2M");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("11M in the eleventh month translates to the first workday of the eleventh month of next year")
    void test11MInNovember() {
        LocalDateTime meetingStart = LocalDateTime.parse("2013-11-21T15:30:00");
        LocalDateTime expected = LocalDateTime.parse("2014-11-03T08:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "11M");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("4M in the ninth month translates to the first workday of the fourth month of next year")
    void test4MInNovember() {
        LocalDateTime meetingStart = LocalDateTime.parse("2019-11-18T15:15:00");
        LocalDateTime expected = LocalDateTime.parse("2020-04-01T08:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "4M");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Q1 in the first quarter translates to the last workday of the first quarter of this year")
    void testQ1InQ1() {
        LocalDateTime meetingStart = LocalDateTime.parse("2003-01-01T10:45:00");
        LocalDateTime expected = LocalDateTime.parse("2003-03-31T08:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "Q1");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Q4 in the second quarter translates to the last workday of the fourth quarter of this year")
    void testQ4InQ2() {
        LocalDateTime meetingStart = LocalDateTime.parse("2001-04-09T09:00:00");
        LocalDateTime expected = LocalDateTime.parse("2001-12-31T08:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "Q4");

        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Q3 in the fourth quarter translates to the last workday of the third quarter of next year")
    void testQ3InQ4() {
        LocalDateTime meetingStart = LocalDateTime.parse("2022-10-06T11:00:00");
        LocalDateTime expected = LocalDateTime.parse("2023-09-29T08:00:00");

        LocalDateTime actual = SwiftScheduling.convertToDeliveryDate(meetingStart, "Q3");

        assertThat(actual).isEqualTo(expected);
    }
}
