package shape;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class BoundingBox {
    ArrayList<Shape> shapes;

    public BoundingBox() {
        shapes = new ArrayList<Shape>();
    }

    public void readInput(String fileName) throws WrongShapeException {
        try(BufferedReader in = new BufferedReader(new FileReader(fileName));
            PrintWriter pw = new PrintWriter("out.txt");)
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

            for(Shape shape : shapes) {
                System.out.println(shape);
            }
        }
        catch(IOException | IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}
