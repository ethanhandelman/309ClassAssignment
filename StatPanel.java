import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
public class StatPanel extends JPanel {
    private List<Point> points;

    public StatPanel(List<Point> ps) {
        this.points = ps;
    }

    @Override
    protected void paintComponent(Graphics g) {
        //draw 5 points

        //draw lines connecting points
    }
}
