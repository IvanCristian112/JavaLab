package org.example;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class InfoCommand implements Command {
    private Catalog catalog;

    public InfoCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void info() throws IOException, SAXException, TikaException {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        FileInputStream inputStream;
        for (Document document : catalog.getDocumentList()) {
            inputStream = new FileInputStream(new File(document.getLocation()));
            parser.parse(inputStream, handler, metadata, context);
            System.out.println("Document 1");
            for (String name : metadata.names()) {
                String value = metadata.get(name);
                System.out.println(name + ": " + value);
            }


        }
    }
}
