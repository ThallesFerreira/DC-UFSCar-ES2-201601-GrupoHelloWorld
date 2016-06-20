package es2.trab.pedro;

import org.junit.Rule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DigitalObjectIdentifierUtilTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testValidDOI() {
        Assert.assertTrue(DigitalObjectIdentifierUtil.validate("10.1000/xyz1000"));
    }

    @Test
    public void testInvalidDOI() {
        Assert.assertFalse(DigitalObjectIdentifierUtil.validate("12.1000/xyz1000"));
        exception.expect(DigitalObjectIdentifierException.class);
    }
}
