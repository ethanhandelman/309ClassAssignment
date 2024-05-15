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

