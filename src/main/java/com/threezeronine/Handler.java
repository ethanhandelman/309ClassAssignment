package com.threezeronine;
import java.awt.event.*;

public class Handler implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        //Repository.getInstance().addPoint(new Point(e.getX(), e.getY()));
        //Repository.getInstance().repaint();
        System.out.println("mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Repository.getInstance().addPoint(new Point(e.getX(), e.getY()));
        System.out.println("MousePressed");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Repository.getInstance().repaint();
        System.out.println("MouseRelease");
        /// ...
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
