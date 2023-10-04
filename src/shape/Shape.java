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
    public abstract ArrayList<Double> getBoundingBox();

    @Override
    public String toString() {
        return ((this.getClass()).toString()).split("[ .]")[2] + " with the center coordinate (x: " + x + ", y: " + y;
    }
}
