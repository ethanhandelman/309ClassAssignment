package com.threezeronine;

import java.awt.*;
import java.util.List;

public class Line {
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        List<Point> list = Repository.getInstance().getList();
        for (int i = 0; i < list.size(); i++){
            if (i == 0){
                continue;
            }
            g.drawLine(list.get(i).getX(), list.get(i).getY(), list.get(i-1).getX(), list.get(i-1).getY());
        }
    }
}
