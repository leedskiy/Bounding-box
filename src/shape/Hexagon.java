package shape;

import java.lang.Math;
import java.util.ArrayList;

public class Hexagon extends Shape{
    private double sideLength;

    public Hexagon(double x, double y, double sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return (3 * Math.sqrt(3) * sideLength * sideLength) / 2;
    }

    @Override
    public ArrayList<Double> getBoundingBox() {
        ArrayList<Double> list1 = new ArrayList<Double>(4);
        double a = sideLength / 2;
        double inradius = Math.sqrt(3) / 2 * a;
        double x1 = x - a;
        double y1 = y - inradius;
        double x2 = x + a;
        double y2 = y + inradius;
        
        list1.add(x1);
        list1.add(y1);
        list1.add(x2);
        list1.add(y2);

        return list1;
    }

    @Override
    public String toString() {
        return super.toString() + ") and side length " + sideLength;
    }
}

