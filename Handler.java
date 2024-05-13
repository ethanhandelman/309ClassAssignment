import java.awt.event.*;

public class Handler implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        // Repository.getInstance().addPoint(new Point(e.getX(), e.getY()));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // ...
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        /// ...
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
