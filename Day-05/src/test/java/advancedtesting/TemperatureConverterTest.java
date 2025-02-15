package advancedtesting;

import junittesting.advancedtesting.tempreture.TemperatureConverter;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private TemperatureConverter temperatureConverter;

    @BeforeEach
    void setUp() {
        temperatureConverter = new TemperatureConverter();
    }

    // Test for Celsius to Fahrenheit conversion
    @Test
    void testCelsiusToFahrenheit() {
        double celsius = 0;
        double expectedFahrenheit = 32;
        assertEquals(expectedFahrenheit, temperatureConverter.celsiusToFahrenheit(celsius), "0°C should be 32°F.");

        celsius = 100;
        expectedFahrenheit = 212;
        assertEquals(expectedFahrenheit, temperatureConverter.celsiusToFahrenheit(celsius), "100°C should be 212°F.");
    }

    // Test for Fahrenheit to Celsius conversion
    @Test
    void testFahrenheitToCelsius() {
        double fahrenheit = 32;
        double expectedCelsius = 0;
        assertEquals(expectedCelsius, temperatureConverter.fahrenheitToCelsius(fahrenheit), "32°F should be 0°C.");

        fahrenheit = 212;
        expectedCelsius = 100;
        assertEquals(expectedCelsius, temperatureConverter.fahrenheitToCelsius(fahrenheit), "212°F should be 100°C.");
    }

    // Test for negative temperatures
    @Test
    void testNegativeTemperatures() {
        double celsius = -40;
        double expectedFahrenheit = -40;
        assertEquals(expectedFahrenheit, temperatureConverter.celsiusToFahrenheit(celsius), "-40°C should be -40°F.");

        double fahrenheit = -40;
        double expectedCelsius = -40;
        assertEquals(expectedCelsius, temperatureConverter.fahrenheitToCelsius(fahrenheit), "-40°F should be -40°C.");
    }
}

