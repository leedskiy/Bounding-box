package shape;
import java.util.ArrayList;

public abstract class Shape {
    protected double x;
    protected double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double getArea();
    public abstract ArrayList<Double> getBoundingBox(double x, double y);
}
