package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command {
    private  Catalog catalog;

    public SaveCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void save(String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                this.catalog);
    }
}
