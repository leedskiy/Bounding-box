package shape;

import java.lang.Math;
import java.util.ArrayList;

public class Triangle extends Shape {
    private double sideLength;

    public Triangle(double x, double y, double sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) / 4 * sideLength * sideLength;
    }

    @Override
    public ArrayList<Double> getBoundingBox() {
        ArrayList<Double> list1 = new ArrayList<Double>();
        double x1 = x - sideLength/2;
        double y1 = y - sideLength/2;
        double x2 = x + sideLength/2;
        double y2 = x + sideLength/2;
        
        list1.add(x1);
        list1.add(y1);
        list1.add(x2);
        list1.add(y2);

        return list1;
    }
}
