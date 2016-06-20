package net.sf.jabref.importer.fileformat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.jabref.model.entry.BibEntry;
import net.sf.jabref.importer.ImportFormatReader;
import net.sf.jabref.importer.OutputPrinter;
import net.sf.jabref.importer.fileformat.ImportFormat;

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
        ArrayList<BibEntry> bibitems = new ArrayList<>();
        BufferedReader in = new BufferedReader(ImportFormatReader.getReaderDefaultEncoding(stream));

        String line = in.readLine();
        String[] fields = line.split(",");
        line = in.readLine();
        while (line != null) {
            if (!"".equals(line.trim())) {
                BibEntry be = new BibEntry();
                int i = 1;
                String[] info = line.split(",");
                be.setType("Book");
                for (String field : Arrays.copyOfRange(fields, 1, fields.length)) {
                    be.setField(field, info[i]);
                    i++;
                }
                bibitems.add(be);
                line = in.readLine();
            }
        }
        return bibitems;
    }

}