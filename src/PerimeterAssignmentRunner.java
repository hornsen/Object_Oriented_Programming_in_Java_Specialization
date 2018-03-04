import java.io.File;
import edu.duke.*;

public class PerimeterAssignmentRunner {

    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;

        // Start with prevPt = the last point
        Point prevPt = s.getLastPoint();

        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);

            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;

            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Start with NumPoints = 0
        int NumPoints=0;

        for (Point currPt : s.getPoints()) {
            NumPoints +=1;
        }

        return NumPoints;
    }

    public double getAverageLength(Shape s) {
        // Start with AverageLength = 0
        double AverageLength = 0.0;

        // Get the number of points and total perimeter
        int numPoints = getNumPoints(s);
        double totalPerim = getPerimeter(s);

        // Calculate average length
        AverageLength = totalPerim / numPoints;

        return AverageLength;
    }

    public double getLargestSide(Shape s) {
        // Start with LargestSide = 0
        double LargestSide = 0;
        // Start with prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Check for largest side
            if(currDist > LargestSide){
                LargestSide = currDist;
            }
        }
        return LargestSide;
    }

    public double getLargestX(Shape s) {
        // Start with LargestX = 0
        double LargestX = 0;
        for (Point currPt : s.getPoints()) {
            if(currPt.getX() > LargestX) {
                LargestX = currPt.getX();
            }
        }
        return LargestX;
    }


    public double getLargestPerimeterMultipleFiles(){
        DirectoryResource dr = new DirectoryResource();
        double perim=0.0;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (perim<getPerimeter(s)){
                perim=getPerimeter(s);
            }
        }
        return perim;
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(-3,4));
        triangle.addPoint(new Point(-3,-4));
        triangle.addPoint(new Point(3,-4));

        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }


    public void testPerimeter () {
        System.out.println("Largest perimeter = " + getLargestPerimeterMultipleFiles());
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);

        double perimeterLength = getPerimeter(s);
        int numPoints = getNumPoints(s);

        double AverageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double LargestX = getLargestX(s);

        System.out.println("Perimeter of object = " + perimeterLength);
        System.out.println("Number of points = " + numPoints);

        System.out.println("Average side length = " + AverageLength);
        System.out.println("Largest side = " + largestSide);
        System.out.println("Largest X = " + LargestX);


    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.triangle();
    }
}


