package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog implements Serializable {
    private String name;
    private List<Document> documentList = new ArrayList<>();
    private Map<Document, Integer> indexMap = new HashMap<>();

    public void add(Document doc) {
        documentList.add(doc);
    }

    public Catalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<Document, Integer> getIndexMap() {
        return indexMap;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public Document findById(String id) {
        return documentList.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", documentList=" + documentList +
                ", indexMap=" + indexMap +
                '}';
    }
}
