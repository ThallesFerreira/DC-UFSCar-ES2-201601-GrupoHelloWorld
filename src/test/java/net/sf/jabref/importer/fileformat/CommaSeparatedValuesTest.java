package net.sf.jabref.importer.fileformat;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import net.sf.jabref.Globals;
import net.sf.jabref.JabRefPreferences;
import net.sf.jabref.importer.OutputPrinterToNull;
import net.sf.jabref.model.entry.BibEntry;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CommaSeparatedValuesTest {

    private final String FILEFORMAT_PATH = "src/test/resources/net/sf/jabref/importer/fileformat";


    /**
     * Generates a List of all files in the package "/src/test/resources/net/sf/jabref/importer/fileformat"
     * @return A list of Names
     * @throws IOException
     */
    public List<String> getTestFiles() throws IOException {
        List<String> files = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(FILEFORMAT_PATH))) {
            stream.forEach(n -> files.add(n.getFileName().toString()));
        }
        return files;
    }

    @BeforeClass
    public static void setUp() {
        Globals.prefs = JabRefPreferences.getInstance();
    }

    @Test(expected = IOException.class)
    public void testImportEntriesException() throws IOException {
        CommaSeparatedValues importer = new CommaSeparatedValues();
        importer.importEntries(null, new OutputPrinterToNull());
    }

    @Test
    public void testGetFormatName() {
        CommaSeparatedValues importer = new CommaSeparatedValues();
        Assert.assertEquals("Comma-Separated Values", importer.getFormatName());
    }

    @Test
    public void testGetCLIId() {
        CommaSeparatedValues importer = new CommaSeparatedValues();
        Assert.assertEquals("csv", importer.getCLIId());
    }

    @Test
    public void testIsRecognizedFormatReject() throws IOException {
        CommaSeparatedValues importer = new CommaSeparatedValues();

        List<String> list = getTestFiles().stream().filter(n -> !n.startsWith("CSVImporterTest"))
                .collect(Collectors.toList());

        for (String str : list) {
            try (InputStream is = CommaSeparatedValues.class.getResourceAsStream(str)) {
                Assert.assertFalse(importer.isRecognizedFormat(is));
            }
        }
    }

    @Test
    public void testImportEmptyEntries() throws IOException {
        CommaSeparatedValues importer = new CommaSeparatedValues();

        try (InputStream is = CommaSeparatedValues.class.getResourceAsStream("Empty.txt")) {
            List<BibEntry> entries = importer.importEntries(is, new OutputPrinterToNull());
            Assert.assertEquals(0, entries.size());
            Assert.assertEquals(Collections.emptyList(), entries);
        }
    }
}