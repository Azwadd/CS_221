package CS_221; /*Created by Azwad Shameem*/
import java.awt.*;

/**An abstract classes which inherits from class Shape2D, which inherits from Shape*/
public abstract class Shape3D extends Shape2D {
    public final double length; // length field added to make it a 3D Shape //

    /**Shape3D class constructor to store the fields of a 3D object and the default fields for Shape and Shape2D
     * @param id input id for the Shape
     * @param name name of the Shape
     * @param description description of the Shape
     * @param color color of the shape
     * @param height the height of the 3D Shape
     * @param width the width of the 3D Shape
     * @param length the length of a 3D Shape*/
    public Shape3D(int id, String name, String description, Color color, double height, double width, double length) {
        super(id, name, description, color, height, width); // Uses super to store default fields for Shape and Shape2D //
        this.length = length; // Stores the length field which makes the Shape 3D //
    }

    /**Creates a string version of all the dimensions
     * @return a formatted string of the dimensions in an organized manner according to pdf*/
    public String getDimensions() { return String.format("%.2f %s %.2f %s %.2f", width, "X", height, "X", length); }

    /**Overrides the previous toString in Shape2D to create a string version of Shape3D instead of Shape2D
     * @return returns a formatted string using Shape2D's toString and then adding on further details included in Shape2D*/
    @Override
    public String toString() {
        String a[] = super.toString().split(" "); // Uses Shape2D toString to split and add into the new string //
        return String.format("%s %s %s %s %s %s %s",a[0], a[1], a[2], getDimensions(), a[8], a[9], a[10]); // Formats the fields of Shape and Shape2D And Shape3D into a string //
    }

    /**Overrides Shape2D's compareTo in order to add more rules for comparisons due to the extra fields in Shape3D
     * @param first takes an instance of shape to compare and sort in the TreeSet
     * @return returns a number depending on the Shape2D's super compareTo plus the length fields that are added in Shape3D*/
    @Override
    public int compareTo(Shape first) {
        int result = super.compareTo(first); // Uses super to utilize Shape2D's compareTo //
        if (result == 0 && first instanceof Shape3D) { // If the instance of Shape is still seemingly equal in comparison //
            Shape3D shape = (Shape3D) first; // Then cast Shape to a Shape3D instance //
            result = Double.compare(shape.length, this.length); // And compare the lengths //
        }
        return result;
    }
}