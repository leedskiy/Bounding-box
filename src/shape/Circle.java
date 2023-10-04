package shape;
import java.lang.Math;
import java.util.ArrayList;

public class Circle extends Shape {
    private double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 2 * radius * Math.PI;
    }

    @Override
    public ArrayList<Double> getBoundingBox() {
        ArrayList<Double> list1 = new ArrayList<Double>(4);
        double x1 = x - radius;
        double y1 = y - radius;
        double x2 = x + radius;
        double y2 = x + radius;
        
        list1.add(x1);
        list1.add(y1);
        list1.add(x2);
        list1.add(y2);

        return list1;
    }

    @Override
    public String toString() {
        return super.toString() + ") and radius " + radius;
    }
}
