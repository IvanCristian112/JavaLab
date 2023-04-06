package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton LoadBtn = new JButton("Load");
    JButton SaveBtn = new JButton("Save");
    JButton ResetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        setLayout(new GridLayout(1, 4));

        exitBtn.addActionListener(this::exitGame);
        add(LoadBtn);
        add(SaveBtn);
        add(ResetBtn);
        add(exitBtn);

    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

}
