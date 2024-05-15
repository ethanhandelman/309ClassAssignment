package com.threezeronine;
// Group 6 - Yud, Safwan, Adya
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import java.util.Comparator;

public class CalculateStat {
    public static List<com.threezeronine.Point> findCornerPoints(List<com.threezeronine.Point> points) {
        if (points.isEmpty()) {
            return points;
        }
        List<com.threezeronine.Point> cornerPoints = new ArrayList<>();

        // Initialize the corner points with the first com.threezeronine.Point in the list
        com.threezeronine.Point topLeft = points.get(0);
        com.threezeronine.Point bottomLeft = points.get(0);
        com.threezeronine.Point bottomRight = points.get(0);
        com.threezeronine.Point topRight = points.get(0);

        // Iterate through the list of points and update the corner points
        for (com.threezeronine.Point point : points) {
            // Update the top-left point
            if (point.getX() + point.getY() < topLeft.getX() + topLeft.getY()) {
                topLeft = point;
            }

            // Update the bottom-left point
            if (point.getX() - point.getY() < bottomLeft.getX() - bottomLeft.getY()) {
                bottomLeft = point;
            }

            // Update the bottom-right point
            if (point.getX() + point.getY() > bottomRight.getX() + bottomRight.getY()) {
                bottomRight = point;
            }

            // Update the top-right point
            if (point.getX() - point.getY() > topRight.getX() - topRight.getY()) {
                topRight = point;
            }
        }

        // Add the corner points to the list
        if (topLeft != null) cornerPoints.add(topLeft);
        if (bottomLeft != null) cornerPoints.add(bottomLeft);
        if (bottomRight != null) cornerPoints.add(bottomRight);
        if (topRight != null) cornerPoints.add(topRight);

        return cornerPoints;
    }

    public static com.threezeronine.Point findMiddlePoint(List <com.threezeronine.Point> points) {
        int totalX = 0;
        int totalY = 0;
        for (com.threezeronine.Point p : points) {
            totalX += p.getX();
            totalY += p.getY();
        }
        return new com.threezeronine.Point(totalX/points.size(), totalY/points.size());
    }
}