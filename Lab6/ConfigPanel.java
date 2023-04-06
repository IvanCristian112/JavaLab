package org.example;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;



    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();

    }

    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        linesLabel = new JLabel("Line probability");
        createButton = new JButton("Create new game");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        String[] probabilities = {"0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0"};
        linesCombo = new JComboBox<>(probabilities);
        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }
}
