package test;

import main.NumberConversion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberConversionTest {

    NumberConversion numberConversion;

    @Before
    public void Setup() {
        numberConversion = new NumberConversion();
    }

    @Test
    public void Should_Get_WordFor_Zero() {
        assertEquals("Zero", numberConversion.toWord(0));
    }

    @Test
    public void Should_Get_WordFor_SingleDigitNumber() {
        assertEquals("Five", numberConversion.toWord(5));
        assertEquals("Seven", numberConversion.toWord(7));
    }

    @Test
    public void Should_Get_WordFor_NumberGreaterThan_Hundred() {
        assertEquals("One Hundred Five", numberConversion.toWord(105));
    }

    @Test
    public void Should_Get_WordFor_NumberGreaterThan_Thousand() {
        assertEquals("One Thousand Ten", numberConversion.toWord(1010));
    }

    @Test
    public void Should_Get_WordFor_NumberGreaterThan_TenThousand() {
        assertEquals("Ten Thousand One Hundred Fifteen", numberConversion.toWord(10115));
    }

    @Test
    public void Should_Get_WordFor_NumberGreaterThanLakh() {
        assertEquals("Twelve Lakh Fourty Thousand One Hundred Fifty One", numberConversion.toWord(1240151));
    }

    @Test
    public void Should_Get_WordFor_NumberGreaterThanCrore() {
        assertEquals("Eight Crore Twelve Lakh Fourty Thousand One Hundred Fifty", numberConversion.toWord(81240150));
    }
}
