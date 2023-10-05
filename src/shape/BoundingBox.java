package shape;
import java.text.DecimalFormat;
import java.math.RoundingMode;  
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class BoundingBox {
    private ArrayList<Shape> shapes;
    private static DecimalFormat df;

    public BoundingBox() {
        shapes = new ArrayList<Shape>();
        df = new DecimalFormat("0.00");  
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
                double sideLengthOrRadius = parseDouble(parts[3]);
                
                switch (parts[0]) {
                    case "c":
                        Circle c1 = new Circle(x, y, sideLengthOrRadius);
                        shapes.add(c1);
                        break;
                    case "t":
                        Triangle t1 = new Triangle(x, y, sideLengthOrRadius);
                        shapes.add(t1);
                        break;
                    case "s":
                        Square s1 = new Square(x, y, sideLengthOrRadius);
                        shapes.add(s1);
                        break;
                    case "h":
                        Hexagon h1 = new Hexagon(x, y, sideLengthOrRadius);
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

        ArrayList<Double> currBoundingBox = new ArrayList<Double>();
        double minX = 0;
        double minY = 0;
        double maxX = 0;
        double maxY = 0;

        for(Shape shape : shapes) {
            currBoundingBox = shape.getBoundingBox();

            if(first) {
                minX = currBoundingBox.get(0);
                minY = currBoundingBox.get(1);
                maxX = currBoundingBox.get(2);
                maxY = currBoundingBox.get(3);
                currBoundingBox.clear();
                first = false;
            }
            else {
                if(currBoundingBox.get(0) < minX) {
                    minX = currBoundingBox.get(0);
                }
                if(currBoundingBox.get(1) < minY) {
                    minY = currBoundingBox.get(1);
                }
                if(currBoundingBox.get(2) > maxX) {
                    maxX = currBoundingBox.get(2);
                }
                if(currBoundingBox.get(3) > maxY) {
                    maxY = currBoundingBox.get(3);
                }

                currBoundingBox.clear();
            }
        }

        ArrayList<Double> list1 = new ArrayList<Double>(4);

        df.setRoundingMode(RoundingMode.DOWN);
        minX = Double.parseDouble(df.format(minX));
        minY = Double.parseDouble(df.format(minY));
        maxX = Double.parseDouble(df.format(maxX));
        maxY = Double.parseDouble(df.format(maxY));

        list1.add(minX);
        list1.add(minY);
        list1.add(maxX);
        list1.add(maxY);
        
        return list1;
    }

    public void printShapes() {
        for(Shape shape : shapes) {
            System.out.println(shape);
        }

        System.out.println();
    }
}
