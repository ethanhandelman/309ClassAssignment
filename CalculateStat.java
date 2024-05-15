import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import java.util.Comparator;

public class CalculateStat {

    public static List<Point> generatePoints(JPanel panel, int numberOfPoints) {
        List<Point> points = new ArrayList<>();
        Dimension panelSize = panel.getSize();
        int panelWidth = panelSize.width;
        int panelHeight = panelSize.height;

        Random random = new Random();

        for (int i = 0; i < numberOfPoints; i++) {
            int x = random.nextInt(panelWidth);
            int y = random.nextInt(panelHeight);
            Point point = new Point(x, y);
            points.add(point);
        }

        return points;
    }
    public static List<Point> findCornerPoints(List<Point> points) {
        if (points.isEmpty()) {
            return points;
        }
        List<Point> cornerPoints = new ArrayList<>();

        // Find the point with the smallest sum of x and y coordinates (top-left)
        Point topLeft = points.stream()
                .min(Comparator.comparingDouble(p -> p.getX() + p.getY()))
                .orElse(null);

        // Find the point with the smallest difference of x and y coordinates (bottom-left)
        Point bottomLeft = points.stream()
                .min(Comparator.comparingDouble(p -> p.getX() - p.getY()))
                .orElse(null);

        // Find the point with the largest sum of x and y coordinates (bottom-right)
        Point bottomRight = points.stream()
                .max(Comparator.comparingDouble(p -> p.getX() + p.getY()))
                .orElse(null);

        // Find the point with the largest difference of x and y coordinates (top-right)
        Point topRight = points.stream()
                .max(Comparator.comparingDouble(p -> p.getX() - p.getY()))
                .orElse(null);

        for (Point p : points) {

        }

        if (topLeft != null) cornerPoints.add(topLeft);
        if (bottomLeft != null) cornerPoints.add(bottomLeft);
        if (bottomRight != null) cornerPoints.add(bottomRight);
        if (topRight != null) cornerPoints.add(topRight);

        return cornerPoints;
    }

    public static Point findMiddlePoint(List <Point> points) {
        int totalX = 0;
        int totalY = 0;
        for (Point p : points) {
            totalX += p.getX();
            totalY += p.getY();
        }
        return new Point(totalX/points.size(), totalY/points.size());
    }
}