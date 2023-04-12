package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton LoadBtn = new JButton("Load");
    JButton SaveBtn = new JButton("Save");
    JButton ExportBtn = new JButton("Export");
    JButton ExitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        setLayout(new GridLayout(1, 4));

        ExitBtn.addActionListener(this::exitGame);
        ExportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File OutputFile = new File("currentPosition.png");
                    ImageIO.write(frame.canvas.image, "png", OutputFile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        SaveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (FileOutputStream fos = new FileOutputStream("gamestate.ser");
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(frame.canvas);
                    oos.close();
                    fos.close();
                } catch (IOException exception) {
                    System.err.println("Error while saving game state: " + exception.getMessage());
                    exception.printStackTrace();
                }
            }
        });
        LoadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fis = new FileInputStream("gamestate.ser");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    DrawingPanel loadedPanel = (DrawingPanel) ois.readObject();
                    loadedPanel.frame = frame;
                    repaint();
                    if (loadedPanel != null) {
                        frame.remove(frame.canvas);
                        frame.canvas = loadedPanel;
                        frame.add(frame.canvas, BorderLayout.CENTER);
                        frame.pack();
                        frame.revalidate();
                        frame.canvas.clearBoard();
                        frame.canvas.drawVertices();
                        frame.canvas.drawLines();

                        repaint();
                    } else {
                        System.err.println("Error while restoring game state");
                    }
                } catch (IOException | ClassNotFoundException exception) {
                    exception.printStackTrace();
                }

            }
        });

        add(LoadBtn);

        add(SaveBtn);

        add(ExportBtn);

        add(ExitBtn);

    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

}
