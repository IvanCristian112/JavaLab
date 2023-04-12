package org.example;

import java.awt.*;
import java.io.Serializable;

public class Line implements Serializable {
    int startXCoordinate;
    int startYCoordinate;
    int endXCoordinate;
    int endYCoordinate;
    Color color = Color.BLACK;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Line(int startXCoordinate, int startYCoordinate, int endXCoordinate, int endYCoordinate) {
        this.startXCoordinate = startXCoordinate;
        this.startYCoordinate = startYCoordinate;
        this.endXCoordinate = endXCoordinate;
        this.endYCoordinate = endYCoordinate;
    }

    @Override
    public String toString() {
        return "Line{" +
                "startXCoordinate=" + startXCoordinate +
                ", startYCoordinate=" + startYCoordinate +
                ", endXCoordinate=" + endXCoordinate +
                ", endYCoordinate=" + endYCoordinate +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Line)) return false;
        Line Line = (Line) obj;
        return ((startXCoordinate == (Line.startXCoordinate)) && (startYCoordinate == (Line.startYCoordinate))
                && (endXCoordinate == (Line.endXCoordinate)) && (endYCoordinate == (Line.endYCoordinate)));

    }
}
