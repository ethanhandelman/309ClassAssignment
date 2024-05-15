import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.List;
public class DummyRepo {
    private static DummyRepo instance;
    private List<Point> points;

    private DummyRepo() {
        super(new Object());
    }
    public static DummyRepo getInstance() {
        if (instance == null) {
            instance = new DummyRepo();
        }
        return instance;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
