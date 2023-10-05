package shape;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws WrongShapeException {
        BoundingBox bb = new BoundingBox();
        bb.readInput("in2.txt");

        ArrayList<Double> cbb = new ArrayList<Double>(4);
        cbb = bb.getCommonBoundingBox();

        System.out.println("--------- Common bounding box ---------\n");
        System.out.println("The bottom-left point BB1(" + cbb.get(0) + ", " + cbb.get(1) + ")");
        System.out.println("The top-right point BB2(" + cbb.get(2) + ", " + cbb.get(3) + ")");
        System.out.println("\n---------------------------------------");
        
        System.out.println("\nAll shapes: \n");
        bb.printShapes();
    }
}
