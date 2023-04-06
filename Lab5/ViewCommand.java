package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {

    public ViewCommand() {
    }

    public void view(Document document) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(document.getLocation()));
    }

}
