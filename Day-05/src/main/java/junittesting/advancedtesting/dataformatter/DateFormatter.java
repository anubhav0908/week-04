package junittesting.advancedtesting.dataformatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    // Method to format date from yyyy-MM-dd to dd-MM-yyyy
    public String formatDate(String inputDate) throws ParseException {
        if (inputDate == null) {
            throw new NullPointerException("Input date is null");
        }

        // Validate the date format first with a regular expression
        if (!inputDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new ParseException("Invalid date format. Expected format: yyyy-MM-dd", 0);
        }

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        inputFormat.setLenient(false);  // Disable lenient parsing to avoid accepting invalid dates like 2025-02-30

        // Try parsing the input date
        Date date = null;
        try {
            date = inputFormat.parse(inputDate);
        } catch (ParseException e) {
            throw new ParseException("Invalid date value: " + inputDate, 0);
        }

        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        return outputFormat.format(date);
    }
}
