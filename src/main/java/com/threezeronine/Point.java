package com.threezeronine;

import java.awt.*;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }

    public void draw(Graphics g){
        int width = Repository.getInstance().getWidth();
        int height = Repository.getInstance().getHeight();
        // half and half topleft
        if (this.x <= width/2 && this.y <= height/2){
            g.setColor(Color.BLUE);
        }
        // half and full bottom left
        else if (this.x <= width/2 && this.y <= height){
            g.setColor(Color.GREEN);
        }
        // full and half topriught
        else if (this.x <= width && this.y <= height/2){
            g.setColor(Color.RED);
        }
        // full and Full bottom right
        else if (this.x <= width && this.y <= height){
            g.setColor(Color.ORANGE);
        }
        g.fillOval(this.x, this.y, 10, 10);
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}
