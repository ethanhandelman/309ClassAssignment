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
        for (Point point : points) {
            point.draw(g2d);
        }

        int middleIndex = points.size() / 2;
        Point middlePoint = points.get(middleIndex);

        // Draw lines connecting points
        g2d.setColor(Color.BLUE);
        for (Point point : points) {
            g2d.drawLine(point.getX(), point.getY(), middlePoint.getX(), middlePoint.getY());
        }
    }

    //    public static void main(String[] args) {
//        List<Point> testPoints = new ArrayList<>();
//        testPoints.add(new Point(50, 50));
//        testPoints.add(new Point(100, 100));
//        testPoints.add(new Point(150, 75));
//        testPoints.add(new Point(200, 125));
//        testPoints.add(new Point(250, 100));
//
//        JFrame frame = new JFrame("StatPanel Test");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 400);
//        frame.setLocationRelativeTo(null);
//
//        StatPanel statPanel = new StatPanel(testPoints);
//        frame.add(statPanel);
//
//        frame.setVisible(true);
//    }

}
