package es2.trab.pedro;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import java.util.GregorianCalendar;

public class YearUtilTest {

    private int actual_year;

    @Before
    public void setUp() {
        actual_year = new GregorianCalendar().get(GregorianCalendar.YEAR);
    }

    @Test
    public void testBelowBottomLimit() {
        Assert.assertFalse(YearUtil.validate(String.valueOf(YearUtil.OLDEST_POSSIBLE - 1)));
    }

    @Test
    public void testEqualBottomLimit() {
        Assert.assertTrue(YearUtil.validate(String.valueOf(YearUtil.OLDEST_POSSIBLE)));
    }

    @Test
    public void testAboveBottomLimit() {
        Assert.assertTrue(YearUtil.validate(String.valueOf(YearUtil.OLDEST_POSSIBLE + 1)));
    }

    @Test
    public void testBelowTopLimit() {
        Assert.assertTrue(YearUtil.validate(String.valueOf(actual_year - 1)));
    }

    @Test
    public void testEqualTopLimit() {
        Assert.assertTrue(YearUtil.validate(String.valueOf(actual_year)));
    }

    @Test
    public void testAboveTopLimit() {
        Assert.assertFalse(YearUtil.validate(String.valueOf(actual_year + 1)));
    }
}
