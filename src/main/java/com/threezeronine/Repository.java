package com.threezeronine;
import java.beans.PropertyChangeSupport;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Repository extends PropertyChangeSupport {
    private static Repository instance = null;
    private int width;
    private int height;

    private List<Point> pointList;

    private Repository() {
        super(new Object());
        this.pointList = new ArrayList<>();
    }

    public static Repository getInstance() {
        if (instance == null){
            instance = new Repository();
        }
        return instance;
    }


    public void addPoint(Point point) {
        this.pointList.add(point);
        System.out.println(pointList);
        sort();
    }

    public void sort(){
        int i, j;
        Point tmp;
        boolean swapped;
        for (i = 0; i < pointList.size()-1; i++){
            swapped = false;
            for (j =0; j < pointList.size()-i-1; j++){
                if (pointList.get(j).getX() > pointList.get(j+1).getX()){
                    tmp = pointList.get(j);
                    pointList.set(j, pointList.get(j+1));
                    pointList.set(j+1, tmp);
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
        System.out.println(pointList);
    }

    public double getDistance(Point p1, Point p2){
        return Math.sqrt((Math.pow(p2.getX()-p1.getX(), 2) + (Math.pow(p2.getY()-p1.getY(), 2))));
    }

    public void setSize(int w, int h){
        this.width = w;
        this.height = h;
    }

    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

    public List<Point> getList(){
        return this.pointList;
    }

    public void repaint(){
        firePropertyChange("repaint", null, null);
    }
}

