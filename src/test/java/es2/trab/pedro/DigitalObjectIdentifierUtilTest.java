package es2.trab.pedro;

import org.junit.Assert;
import org.junit.Test;


public class DigitalObjectIdentifierUtilTest {

    @Test
    public void testValidDOI() {
        Assert.assertTrue(DigitalObjectIdentifierUtil.validate("10.1000/xyz1000"));
    }

    @Test
    public void testInvalidDOI() {
        Assert.assertFalse(DigitalObjectIdentifierUtil.validate("12.1000/xyz1000"));
    }
}
