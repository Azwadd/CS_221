package CS_221; /*Created by Azwad Shameem*/
import java.awt.*;

/**An abstract classes which inherits from class Shape*/
public abstract class Shape2D extends Shape {
    public final double height; // New variable height for a 2D shape//
    public final double width; // New variable width for a 2D shape //

    /**Shape2D class constructor stores the default fields for the shape and the new fields for Shape2D
     * @param id input id for the Shape
     * @param name name of the Shape
     * @param description description of the Shape
     * @param color color of the shape
     * @param height the height of the 2D Shape
     * @param width the width of the 2D Shape*/
    public Shape2D(int id, String name, String description, Color color, double height, double width) {
        super(id, name, description, color); // Uses super to call the constructor of Shape and store its fields //
        this.height = height;  // Stores height for a 2D Shape//
        this.width = width; // Stores width for a 2D shape //
    }

    /**Creates a string version of all the dimensions
     * @return a formatted string of the dimensions in an organized manner according to pdf*/
    public String getDimensions() { return String.format("%.2f %s %.2f", width, "X", height); }

    /**Overrides the previous toString in Shape to create a string version of Shape2D instead of Shape
     * @return returns a formatted string using Shape's toString and then adding on further details included in Shape2D*/
    @Override
    public String toString() {
        String a[] = super.toString().split(" "); // Uses Shape toString to split and add into the new string //
        return String.format("%s %s %s %s %s %s %s",a[0], a[1], a[2], getDimensions(), a[3], a[4], a[5]); // Formats the fields of Shape and Shape2D into a string //
    }

    /**Overrides Shape's compareTo in order to add more rules for comparisons due to the extra fields in Shape2D
     * @param first takes an instance of shape to compare and sort in the TreeSet
     * @return returns a number depending on the Shape's super compareTo plus the height, width fields that are added in Shape2D*/
    @Override
    public int compareTo(Shape first) {
        int result = super.compareTo(first); // Uses super to utilize Shape's compareTo //
        if (result == 0 && first instanceof Shape2D) { // If the instance of Shape is still seemingly equal in comparison //
            Shape2D shape = (Shape2D)first; // Then cast Shape to a Shape2D instance //
            result = Double.compare(this.height, shape.height); // And compare the heights //
            if (result == 0){   // If somehow they still seem equal //
                result = Double.compare(this.width, shape.width); // Then compare the widths //
            }
        }
        return result;
    }
}