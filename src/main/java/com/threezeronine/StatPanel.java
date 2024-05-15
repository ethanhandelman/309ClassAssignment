package com.threezeronine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class StatPanel extends JPanel {
    private List<Point> points;

    public StatPanel(List<Point> ps) {
        this.points = ps;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw points
        g2d.setColor(Color.BLUE);
        for (Point point : points) {
            int x = (int) point.getX();
            int y = (int) point.getY();
            g2d.fillOval(x - 5, y - 5, 10, 10);
        }

        int middleIndex = points.size() / 2;
        Point middlePoint = points.get(middleIndex);

        // Draw lines connecting points
        g2d.setColor(Color.BLUE);
        for (Point point : points) {
            g2d.drawLine((int) point.getX(), (int) point.getY(), (int) middlePoint.getX(), (int) middlePoint.getY());
        }
    }

}
