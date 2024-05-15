package com.threezeronine;

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
            if (smallestX > p.getX()) smallestX = p.getX();
            if (smallestY > p.getY()) smallestY = p.getY();
            if (greatestX < p.getX()) greatestX = p.getX();
            if (greatestY < p.getY()) greatestY = p.getY();
        }

        calculateFactor();

        for (Point p : points) {
            p.setX((int) (p.getX() * factor));
            p.setY((int) (p.getY() * factor));
        }

        return points;
    }

    private static void calculateFactor(){
        double total_height = greatestY - smallestY;
        double total_width = greatestX - smallestX;

        Repository repository = Repository.getInstance();
        double xFactor = repository.getHeight()/total_height;
        double yFactor = repository.getWidth()/total_width;

        if (xFactor < yFactor)
            factor = xFactor;
        else
            factor = yFactor;
    }
}
