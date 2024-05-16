package com.threezeronine;
import java.awt.event.*;

/**
 * @author Fisher Lyon, Leo Rivera, Eric Berber
 */
public class Handler implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Repository.getInstance().addPoint(new Point(e.getX(), e.getY()));

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Repository.getInstance().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
