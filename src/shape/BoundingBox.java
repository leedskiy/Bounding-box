package shape;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class BoundingBox {
    ArrayList<Shape> shapes;

    public BoundingBox() {
        shapes = new ArrayList<Shape>();
    }

    public void readInput(String fileName) throws WrongShapeException {
        try(BufferedReader in = new BufferedReader(new FileReader(fileName)))
        {
            int n = parseInt(in.readLine());

            for(int i = 0; i < n; ++i) {
                String line = in.readLine();
                String[]parts = line.split(" ");
                
                double x = parseDouble(parts[1]);
                double y = parseDouble(parts[2]);
                double sideLength = parseDouble(parts[3]);
                
                switch (parts[0]) {
                    case "c":
                        Circle c1 = new Circle(x, y, sideLength);
                        shapes.add(c1);
                        break;
                    case "t":
                        Triangle t1 = new Triangle(x, y, sideLength);
                        shapes.add(t1);
                        break;
                    case "s":
                        Square s1 = new Square(x, y, sideLength);
                        shapes.add(s1);
                        break;
                    case "h":
                        Hexagon h1 = new Hexagon(x, y, sideLength);
                        shapes.add(h1);
                        break;
                    default:
                        throw new WrongShapeException("The shape \"" + parts[0] + "\" in the input is not supported");
                }
            }
        }
        catch(IOException | IllegalArgumentException e) {
            System.err.println(e);
        }
    }

    public ArrayList<Double> getCommonBoundingBox() {
        boolean first = true;

        double minX = 0;
        double minY = 0;
        double maxX = 0;
        double maxY = 0;

        for(Shape shape : shapes) {
            if(first) {
                minX = shape.getBoundingBox().get(0);
                minY = shape.getBoundingBox().get(1);
                maxX = shape.getBoundingBox().get(2);
                maxY = shape.getBoundingBox().get(3);
                first = false;
            }
            else {
                if(shape.getBoundingBox().get(0) < minX) {
                    minX = shape.getBoundingBox().get(0);
                }
                if(shape.getBoundingBox().get(1) < minY) {
                    minY = shape.getBoundingBox().get(1);
                }
                if(shape.getBoundingBox().get(2) > maxX) {
                    maxX = shape.getBoundingBox().get(2);
                }
                if(shape.getBoundingBox().get(3) > maxY) {
                    maxY = shape.getBoundingBox().get(3);
                }
            }
        }

        ArrayList<Double> list1 = new ArrayList<Double>(4);
        list1.add(minX);
        list1.add(minY);
        list1.add(maxX);
        list1.add(maxX);
        return list1;
    }

    public void printShapes() {
        for(Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println();
    }
}
