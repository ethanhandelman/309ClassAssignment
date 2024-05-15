package com.threezeronine;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Canvas extends JPanel implements PropertyChangeListener {

    public Canvas() {
        // ...
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // ...
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'propertyChange'");
    }
    
}
