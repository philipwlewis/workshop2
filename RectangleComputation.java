
// RectangleComputation application
// Print the area and perimeter of a rectangle, given its height and width
public class RectangleComputation {
    public static void main(String[] args) {
    // Declare 2 variables of double type.
    double height = Double.parseDouble(args[0]), width = Double.parseDouble(args[1]), area, perimeter;
    // Compute area and circumference
    area = height * width;
    perimeter = 2.0 * ( height + width );
    System.out.println("The area is " + area); 
    System.out.println("The perimeter is " + perimeter); 
    }
}