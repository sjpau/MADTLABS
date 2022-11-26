package xyz.mobyus.labs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static xyz.mobyus.labs.StringParser.CountChars;
import static xyz.mobyus.labs.StringParser.CountStrings;

public class StringParserUnitTest {
    @Test
    public void CountStringsTest() {

        int expected = 3;
        int actual = CountStrings("i like pizza");
        assertEquals(expected, actual);

        expected = 0;
        actual = CountStrings("");
        assertEquals(expected, actual);

        expected = 0;
        actual = CountStrings(" ");
        assertEquals(expected, actual);

    }
    @Test
    public void CountCharsTest(){

        int expected = 0;
        int actual = CountChars("");
        assertEquals(expected, actual);

        expected = 0;
        actual = CountChars("      ");
        assertEquals(expected, actual);

        expected = 5;
        actual = CountChars("!@#$%");
        assertEquals(expected, actual);
    }
}