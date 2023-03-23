package org.example;

import javax.print.Doc;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public  class Document implements Serializable {
    private String id;
    private String title;
    private String location;
    private static int counter = 0;
    private Map<String, Object> tags = new HashMap<>();


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public Document(String title, String location) {
        this.title = title;
        this.location = location;
        id = Integer.toString(counter);
        counter++;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Document)) return false;
        Document document = (Document) obj;
        return id.equals(document.getId());

    }
}
