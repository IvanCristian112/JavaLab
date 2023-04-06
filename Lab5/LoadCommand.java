package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command {
    private Catalog catalog;

    public LoadCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
       catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);

    }
}
