package org.example;

import javax.print.Doc;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        var book = new Document("Introducere in Java","C:\\Users\\Victor\\Downloads");
        book.addTag("author","Livius Ciocarlie");
        var article = new Document("New aspects on API implementation","C:\\Users\\Victor\\Downloads");
        article.addTag("article","Andrache Mihai");
        var catalog = new Catalog("Java");
        catalog.add(book);
        catalog.add(article);
        System.out.println(catalog);
        CatalogUtil catalogUtil = new CatalogUtil();
        try {
            catalogUtil.save(catalog,"C:\\Users\\Victor\\Desktop\\catalog.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}