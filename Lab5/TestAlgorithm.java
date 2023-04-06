package org.example;

import org.jheaps.annotations.VisibleForTesting;

import javax.print.Doc;
import javax.swing.event.DocumentEvent;


public class TestAlgorithm {
    private GreedyColoringAlgorithm greedyColoringAlgorithm;
    private JGraphTAlgorithm jGraphTAlgorithm;

    public TestAlgorithm() {

    }

    public void generateProblem(int numberOfInstances) {
        Catalog catalog = new Catalog("Abecedar");
        AddCommand Add = new AddCommand(catalog);
        for (int i = 0; i < numberOfInstances; i++) {
            var document = new Document(Integer.toString(i), "C:\\Users");
            Add.add(document);
        }
        String[] tags = new String[(int) Math.sqrt(numberOfInstances)];
        for (int i = 0; i < tags.length; i++) {
            tags[i] = Integer.toString(i);
        }
        for (Document document : catalog.getDocumentList()) {
            int x = (int) (Math.random() * tags.length);
            int y = (int) (Math.random() * tags.length);
            int z = (int) (Math.random() * tags.length);
            document.addTag(tags[x]);
            document.addTag(tags[y]);
            document.addTag(tags[z]);
        }
        greedyColoringAlgorithm = new GreedyColoringAlgorithm(catalog);
        jGraphTAlgorithm = new JGraphTAlgorithm(catalog);
    }

    public void simpleTest() {
        Document[] documents = new Document[6];
        for (int i = 0; i < 6; i++) {
            documents[i] = new Document(Integer.toString(i), "C:\\Users:\\Victor");
        }
        documents[0].addTag("a");
        documents[0].addTag("b");
        documents[1].addTag("a");
        documents[1].addTag("c");
        documents[2].addTag("a");
        documents[2].addTag("b");
        documents[2].addTag("d");
        documents[3].addTag("b");
        documents[4].addTag("d");
        documents[4].addTag("f");
        documents[5].addTag("c");
        documents[5].addTag("f");
        Catalog catalog = new Catalog("Abecedar");
        AddCommand Add = new AddCommand(catalog);
        for (int i = 0; i < 6; i++) {
            Add.add(documents[i]);
        }
        greedyColoringAlgorithm = new GreedyColoringAlgorithm(catalog);
        jGraphTAlgorithm = new JGraphTAlgorithm(catalog);
        int greedyChromaticNumber = greedyColoringAlgorithm.solve();
        int jGraphChromaticNumber = jGraphTAlgorithm.solve();
        if (greedyChromaticNumber == jGraphChromaticNumber) {
            System.out.println("Ambele algoritme au acelasi rezultat");
        }
    }

    public int testGreedyAlgorithm(int numberOfInstances) {
        System.gc();
        long initialTime = System.currentTimeMillis();
        generateProblem(numberOfInstances);
        long runningTime = System.currentTimeMillis() - initialTime;
        int result = greedyColoringAlgorithm.solve();
        System.out.println("Timpul de rulare: " + runningTime);
        System.out.println("Numarul cromatic: " + result);
        return result;
    }

    public int testJGraphAlgorithm(int numberOfInstances) {
        System.gc();
        long initialTime = System.currentTimeMillis();
        generateProblem(numberOfInstances);
        long runningTime = System.currentTimeMillis() - initialTime;
        int result = jGraphTAlgorithm.solve();
        System.out.println("Timpul de rulare: " + runningTime);
        System.out.println("Numarul cromatic: " + result);
        return result;

    }

}
