package shape;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

public class BoundingBox {
    ArrayList<Shape> shapes;

    public BoundingBox() {
        shapes = new ArrayList<Shape>();
    }

    public void readInput(String fileName) {
        try(BufferedReader in = new BufferedReader(new FileReader(fileName));
            PrintWriter pw = new PrintWriter("out.txt");)
        {
            

        }
        catch(IOException | IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}
