package org.example;


import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        var book = new Document("LFAC-Curs6", "C:\\Users\\Victor\\Downloads\\munte.jpg");
        book.addTag("Livius Ciocarlie");
        var article = new Document("New aspects on API implementation", "C:\\Users\\Victor\\Downloads\\test.txt");
        article.addTag("Andrache Mihai");
        var book2 = new Document("LFAC", "C:\\Users\\Victor\\Downloads\\lfac4.pdf");
        book2.addTag("Livius Ciocarlie");
        var catalog = new Catalog("Java");
        AddCommand add = new AddCommand(catalog);
        add.add(book);
        add.add(article);
        add.add(book2);
        System.out.println(catalog);
        ViewCommand view = new ViewCommand();
        try {
            view.view(book);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ReportCommand report = new ReportCommand(catalog);
        try {
            report.report();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        InfoCommand info = new InfoCommand(catalog);
        try {
            info.info();
        } catch (TikaException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        ListCommand list = new ListCommand(catalog);

        TestAlgorithm testAlgorithm = new TestAlgorithm();
        testAlgorithm.simpleTest();

        for (int i = 0; i < 10; i++) {
            testAlgorithm.testGreedyAlgorithm(1000);
            //testAlgorithm.testJGraphAlgorithm(1000);
        }


    }
}