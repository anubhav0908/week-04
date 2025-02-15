package basictesting;

import junittesting.basictesting.stringutility.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void testReverse() {
        assertEquals("cba", StringUtils.reverse("abc"));
        assertEquals("edcba", StringUtils.reverse("abcde"));
        assertEquals("", StringUtils.reverse(""));
        assertEquals("a", StringUtils.reverse("a"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("madam"));
        assertFalse(StringUtils.isPalindrome("hello"));
        assertTrue(StringUtils.isPalindrome("a"));
        assertFalse(StringUtils.isPalindrome(""));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));
        assertEquals("WORLD", StringUtils.toUpperCase("world"));
        assertEquals("", StringUtils.toUpperCase(""));
        assertEquals("JAVA", StringUtils.toUpperCase("java"));
    }
}

