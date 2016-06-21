package net.sf.jabref.model.entry;

import es2.trab.pedro.YearUtil;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BibEntryTest {
    private BibEntry entry;

    @Before
    public void setUp() {
        entry = new BibEntry();
    }

    @After
    public void tearDown() {
        entry = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void notOverrideReservedFields() {
        entry.setField(BibEntry.ID_FIELD, "somevalue");
    }

    @Test(expected = IllegalArgumentException.class)
    public void notClearReservedFields() {
        entry.clearField(BibEntry.ID_FIELD);
    }

    @Test
    public void invalidArticleYearInput() {
        String value = String.valueOf(YearUtil.OLDEST_POSSIBLE - 10);
        entry.setType("article");
        entry.setField("year", value);
        Assert.assertFalse(entry.getField("year").equals(value));
    }

    @Test
    public void validArticleYearInput() {
        String value = String.valueOf(YearUtil.OLDEST_POSSIBLE + 10);
        entry.setType("article");
        entry.setField("year", value);
        Assert.assertTrue(entry.getField("year").equals(value));
    }

    @Test
    public void validArticleDOIInput() {
        String value = "10.1000/xyz1000";
        entry.setType("article");
        entry.setField("doi", value);
        Assert.assertTrue(entry.getField("doi").equals(value));
    }

    @Test
    public void invalidArticleDOIInput() {
        String value = "15.1000/xyz1000";
        entry.setType("article");
        entry.setField("doi", value);
        Assert.assertFalse(entry.getField("doi").equals(value));
    }

    @Test
    public void invalidBookYearInput() {
        String value = String.valueOf(YearUtil.OLDEST_POSSIBLE - 10);
        entry.setType("book");
        entry.setField("year", value);
        Assert.assertFalse(entry.getField("year").equals(value));
    }

    @Test
    public void validBookYearInput() {
        String value = String.valueOf(YearUtil.OLDEST_POSSIBLE + 10);
        entry.setType("book");
        entry.setField("year", value);
        Assert.assertTrue(entry.getField("year").equals(value));
    }

    @Test
    public void validBookDOIInput() {
        String value = "10.1000/xyz1000";
        entry.setType("book");
        entry.setField("doi", value);
        Assert.assertTrue(entry.getField("doi").equals(value));
    }

    @Test
    public void invalidBookDOIInput() {
        String value = "15.1000/xyz1000";
        entry.setType("book");
        entry.setField("doi", value);
        Assert.assertFalse(entry.getField("doi").equals(value));
    }
}