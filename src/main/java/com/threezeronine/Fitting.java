import java.awt.*;
import java.util.ArrayList;

/**
 * @author Andy Duong, Riya Badadare, Saylor Benes
 */
public class Fitting {

    private static double factor;
    private static double smallestX, smallestY = Integer.MAX_VALUE;
    private static double greatestX, greatestY = Integer.MIN_VALUE;


    public static ArrayList<Point> fit(ArrayList<Point> points){

        for(Point p : points){
            if (smallestX > p.x) smallestX = p.x;
            if (smallestY > p.y) smallestY = p.y;
            if (greatestX < p.x) greatestX = p.x;
            if (greatestY < p.y) greatestY = p.y;
        }

        calculateFactor();

        for (Point p : points) {
            p.setLocation(p.x * factor, p.y * factor);
        }

        return points;
    }

    private static void calculateFactor(){
        double total_height = greatestY - smallestY;
        double total_width = greatestX - smallestX;

        Repository repository = Repository.getInstance();
        double xFactor = repository.getScreenHeight()/total_height;
        double yFactor = repository.getScreenWidth()/total_width;

        if (xFactor < yFactor)
            factor = xFactor;
        else
            factor = yFactor;
    }
}
