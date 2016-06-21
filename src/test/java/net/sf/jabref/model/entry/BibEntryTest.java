package net.sf.jabref.model.entry;

import es2.trab.pedro.YearUtil;
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
        entry.setType("article");
        entry.setField("year", String.valueOf(YearUtil.OLDEST_POSSIBLE - 10));
    }

    @Test
    public void validArticleYearInput() {
        entry.setType("article");
        entry.setField("year", String.valueOf(YearUtil.OLDEST_POSSIBLE + 10));
    }

    @Test
    public void validArticleDOIInput() {
        entry.setType("article");
        entry.setField("doi", "10.1000/xyz1000");
    }

    @Test
    public void invalidArticleDOIInput() {
        entry.setType("article");
        entry.setField("doi", "15.1000/xyz1000");
    }

    @Test
    public void invalidBookYearInput() {
        entry.setType("book");
        entry.setField("year", String.valueOf(YearUtil.OLDEST_POSSIBLE - 10));
    }

    @Test
    public void validBookYearInput() {
        entry.setType("book");
        entry.setField("year", String.valueOf(YearUtil.OLDEST_POSSIBLE + 10));
    }

    @Test
    public void validBookDOIInput() {
        entry.setType("book");
        entry.setField("doi", "10.1000/xyz1000");
    }

    @Test
    public void invalidBookDOIInput() {
        entry.setType("book");
        entry.setField("doi", "15.1000/xyz1000");
    }
}