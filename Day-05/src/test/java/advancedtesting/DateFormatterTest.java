package advancedtesting;

import junittesting.advancedtesting.dataformatter.DateFormatter;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;

class DateFormatterTest {

    private DateFormatter dateFormatter;

    @BeforeEach
    void setUp() {
        dateFormatter = new DateFormatter();
    }

    // Test for valid date format
    @Test
    void testValidDate() throws ParseException {
        String inputDate = "2025-02-15";
        String expectedOutput = "15-02-2025";
        assertEquals(expectedOutput, dateFormatter.formatDate(inputDate), "The date format should be converted correctly.");
    }

    // Test for invalid date format (wrong input format)
    @Test
    void testInvalidDateFormat() {
        String inputDate = "15-02-2025"; // Invalid format, should be yyyy-MM-dd
        assertThrows(ParseException.class, () -> {
            dateFormatter.formatDate(inputDate);
        }, "The input date format should be yyyy-MM-dd.");
    }

    // Test for invalid date (e.g., non-existing date like 2025-02-30)
    @Test
    void testInvalidDate() {
        String inputDate = "2025-02-30"; // Invalid date
        assertThrows(ParseException.class, () -> {
            dateFormatter.formatDate(inputDate);
        }, "The input date should be a valid date.");
    }

    // Test for an empty input string
    @Test
    void testEmptyDate() {
        String inputDate = ""; // Empty string should throw ParseException
        assertThrows(ParseException.class, () -> {
            dateFormatter.formatDate(inputDate);
        }, "An empty input string should throw a ParseException.");
    }

    // Test for null input
    @Test
    void testNullDate() {
        assertThrows(NullPointerException.class, () -> {
            dateFormatter.formatDate(null); // Null should throw NullPointerException
        }, "Null input should throw a NullPointerException.");
    }
}
