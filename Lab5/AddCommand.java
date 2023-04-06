package org.example;

public class AddCommand implements Command {
    private Catalog catalog;

    public AddCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void add(Document document) {
        catalog.getDocumentList().add(document);
        catalog.getIndexMap().put(document, catalog.getDocumentList().size() - 1);
    }


}
