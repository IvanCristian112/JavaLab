package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class DrawingPanel extends JPanel implements Serializable {
    private static final long serialVersionUID = 1L;
    MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices = 6;
    private double EdgeProbability = 1.0;
    private int currentPlayer = 0;
    private final int[] playerColors = {0, 1};

    Set<Line> lines = new HashSet<>();
    transient BufferedImage image;
    transient Graphics2D graphics;
    int[] x, y;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
        createOffscreenImage();
        createBoard(this.numVertices, this.EdgeProbability);
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX();
                int y = e.getY();
                handleLineClick(x, y);
            }
        });
    }

    private Color getPlayerColor(int playerColorIndex) {
        if (playerColorIndex == 0) {
            return Color.RED;
        } else if (playerColorIndex == 1) {
            return Color.GREEN;
        } else {
            return Color.BLACK; // Default fallback color
        }
    }

    public DrawingPanel loadFromFile(String filename, MainFrame frame) {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            DrawingPanel loadedPanel = (DrawingPanel) ois.readObject();
            loadedPanel.frame = frame;
            clearBoard();
            drawLines();
            drawVertices();
            repaint();
            return loadedPanel;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void handleLineClick(int x, int y) {
        double clickThreshold = 5; // Adjust this value as needed
        for (Line line : lines) {
            double distance = pointToLineDistance(x, y, line.startXCoordinate, line.startYCoordinate, line.endXCoordinate, line.endYCoordinate);
            if (distance <= clickThreshold && line.color == Color.BLACK) {
                System.out.println("Hello");
                // Line is clicked, perform your action
                line.setColor(getPlayerColor(currentPlayer));
                graphics.setColor(getPlayerColor(currentPlayer));
                graphics.drawLine(line.startXCoordinate, line.startYCoordinate, line.endXCoordinate, line.endYCoordinate);

                repaint();
                if (checkForTriangle(this.lines, getPlayerColor(currentPlayer))) {
                    System.out.println("Jucatorul " + currentPlayer + " a castigat");
                } else {
                    currentPlayer = (currentPlayer + 1) % 2;
                }
            }
        }
    }

    boolean checkForTriangle(Set<Line> lines, Color playerColor) {
        Set<Line> CurrentPlayerLines = new HashSet<>();
        for (Line line : lines) {
            if (line.color == playerColor) CurrentPlayerLines.add(line);
        }
        System.out.println(CurrentPlayerLines.size());
        for (Line line : CurrentPlayerLines) {
            for (Line line2 : CurrentPlayerLines) {
                if (sharePoint(line, line2) && line != line2) {
                    for (Line line3 : CurrentPlayerLines) {
                        if (sharePoint(line, line3) && sharePoint(line2, line3) && line != line3 && line2 != line3)
                            return true;
                    }
                }
            }
        }
        return false;
    }

    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
        input.defaultReadObject();
        createOffscreenImage(); // Recreate the BufferedImage object after deserialization
        graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }


    private boolean sharePoint(Line line1, Line line2) {
        return (line1.startXCoordinate == line2.startXCoordinate && line1.startYCoordinate == line2.startYCoordinate)
                || (line1.startXCoordinate == line2.endXCoordinate && line1.startYCoordinate == line2.endYCoordinate)
                || (line1.endXCoordinate == line2.startXCoordinate && line1.endYCoordinate == line2.startYCoordinate)
                || (line1.endXCoordinate == line2.endXCoordinate && line1.endYCoordinate == line2.endYCoordinate);
    }

    private double pointToLineDistance(int x, int y, int x1, int y1, int x2, int y2) {
        double lineLength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (lineLength == 0) {
            return Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
        }
        double t = ((x - x1) * (x2 - x1) + (y - y1) * (y2 - y1)) / (lineLength * lineLength);
        t = Math.max(0, Math.min(1, t));
        double projX = x1 + t * (x2 - x1);
        double projY = y1 + t * (y2 - y1);
        return Math.sqrt(Math.pow(x - projX, 2) + Math.pow(y - projY, 2));
    }

    void createBoard(int numVertices, double EdgeProbability) {
        this.numVertices = numVertices;
        this.EdgeProbability = EdgeProbability;
        lines.clear();
        clearBoard();
        createVertices();
        createLines();
        drawLines();
        drawVertices();
        repaint();
    }

    void clearBoard() {

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
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

    private void createLines() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = i; j < numVertices; j++) {
                if (i == j) continue;
                double randomVariable = Math.random();
                if (this.EdgeProbability > randomVariable) {
                    lines.add(new Line(x[i], y[i], x[j], y[j]));
                }
            }
        }
    }

    void drawVertices() {
        for (int i = 0; i < numVertices; i++) {
            graphics.setColor(Color.BLACK);
            graphics.fillOval(x[i], y[i], 10, 10);
        }
    }

    void drawLines() {
        graphics.setStroke(new BasicStroke(1));

        for (Line line : this.lines) {
            graphics.setColor(line.getColor());
            graphics.drawLine(line.startXCoordinate, line.startYCoordinate, line.endXCoordinate, line.endYCoordinate);
        }

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
