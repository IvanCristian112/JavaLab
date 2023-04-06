package org.example;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.awt.*;
import java.io.*;

public class ReportCommand implements Command {
    private Catalog catalog;

    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void report() throws Exception {
        Velocity.init();
        Template template = Velocity.getTemplate("./HTMLdocument.vm");
        VelocityContext context = new VelocityContext();
        context.internalPut("documents", catalog.getDocumentList());
        File file = new File("Report.html");
        Writer writer = new FileWriter(file);
        template.merge(context, writer);

        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }

}
