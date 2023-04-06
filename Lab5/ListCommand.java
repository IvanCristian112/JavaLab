package org.example;

public class ListCommand implements Command {
    private  Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void list()  {
        for(Document document : catalog.getDocumentList()){
            System.out.println(document.getTitle());
        }
    }


}
