package es2.trab.pedro;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.GregorianCalendar;

public class YearUtilTest {

    private int actual_year;

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Before
    public void setUp() {
        actual_year = new GregorianCalendar().get(GregorianCalendar.YEAR);
    }

    @Test
    public void testBelowBottomLimit() throws Exception {
        Assert.assertFalse(YearUtil.validate(String.valueOf(YearUtil.OLDEST_POSSIBLE - 1)));
        exception.expect(YearException.class);
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
    public void testAboveTopLimit() throws Exception {
        Assert.assertFalse(YearUtil.validate(String.valueOf(actual_year + 1)));
        exception.expect(YearException.class);
    }
}
