package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double EdgeProbability;
    BufferedImage image;
    Graphics2D graphics;
    int[] x, y;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
        createOffscreenImage();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }

    private void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        EdgeProbability = Double.valueOf(frame.configPanel.linesCombo.getSelectedItem().toString());
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);

    }


    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawVertices() {
        for (int i = 0; i < numVertices; i++) {
            graphics.setColor(Color.BLACK);
            graphics.fillOval(x[i], y[i], 10, 10);
        }
    }

    private void drawLines() {
        graphics.setStroke(new BasicStroke(1));
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < numVertices - 1; i++) {
            graphics.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
        }
        graphics.drawLine(x[0], y[0], x[numVertices - 1], y[numVertices - 1]);
    }


    @Override
    protected void paintComponent(Graphics g) {
        //get the number of dots (numVertices)
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        //get the probability that two dots form a line (edgeProbability)
        //draw the board, that is:
        //compute the coordinates of the dots
        //draw the dots
        //draw the lines

    }

    @Override
    public void update(Graphics g) {
    }


}
