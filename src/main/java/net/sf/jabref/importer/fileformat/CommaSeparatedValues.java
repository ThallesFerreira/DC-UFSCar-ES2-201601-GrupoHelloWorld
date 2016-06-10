package net.sf.jabref.importer.fileformat;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.jabref.importer.OutputPrinter;
import net.sf.jabref.model.entry.BibEntry;

public class CommaSeparatedValues extends ImportFormat{


    @Override
    public String getFormatName() {
        return "Comma-Separated Values";
      }

    @Override
    public String getCLIId() {
        return "commaseparatedvalues";
    }

    @Override
    public boolean isRecognizedFormat(InputStream stream) throws IOException {
        return true; // this is discouraged except for demonstration purposes
    }

    @Override
    public List<BibEntry> importEntries(InputStream stream, OutputPrinter status) throws IOException {
        List<BibEntry> bibItems = new ArrayList<>();
        return bibItems;
    }

}