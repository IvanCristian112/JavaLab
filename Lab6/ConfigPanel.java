    package org.example;

    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

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
            String[] probabilities = {"1.0", "0.9", "0.8", "0.7", "0.6", "0.5", "0.4", "0.3", "0.2", "0.1"};
            linesCombo = new JComboBox<>(probabilities);
            createButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int numVertices = (int) dotsSpinner.getValue();
                    double EdgeProbability = Double.valueOf(linesCombo.getSelectedItem().toString());

                    frame.canvas.createBoard(numVertices,EdgeProbability);
                }
            });
            add(dotsLabel);
            add(dotsSpinner);
            add(linesLabel);
            add(linesCombo);
            add(createButton);
        }
    }
