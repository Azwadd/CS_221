package CS_221; /*Created by Azwad Shameem*/
import java.util.TreeSet;

/**ShapeList class extends TreeSet class and acts as a TreeSet to store the shapes*/
public class ShapeList extends TreeSet<Shape> {
    /**ShapeList is a TreeSet already and the constructor actually may not have to do anything*/
    public ShapeList() {}

    /**Adds shapes into the ShapeList
     * @param first inputs this instance into the ShapeList
     * @return returns true if element is added otherwise returns false if the element is already in the ShapeList and is not added*/
    public boolean add(Shape first) {
        if (contains(first)) { return false; // If the first instance is already in the ShapeList don't input //
        } else { // Otherwise use super.add to add the instance first into the ShapeList just like you would add into a TreeSet //
            super.add(first);
            return true;
        }
    }

    /**Gets all the 2D shapes of the current ShapeList and puts it into another ShapeList to return
     * @return returns a ShapeList of all the 2D shapes*/
    public ShapeList get2DShapes() {
        ShapeList shapes2d = new ShapeList(); // Creates a ShapeList to store only 2D shapes //
        for (Shape i : this) { // Enhanced for loops to loop through all the shapes in the ShapeList //
            if (i instanceof Quadrilateral) { // Checks if the element is a 2D Shape (Quadrilateral since in the test file it is instantiated as a Quadrilateral for 2D shapes //
                shapes2d.add(i); // Adds into the ShapeList that only contains 2D Shapes //
            }
        }
        return shapes2d;
    }

    /**Gets all the 3D shapes of the current ShapeList and puts it into another ShapeList to return
     * @return returns a ShapeList of all the 3D shapes*/
    public ShapeList get3DShapes() {
        ShapeList shapes3d = new ShapeList(); // Creates a ShapeList to store only 3D shapes //
        for (Shape i : this) {  // Enhanced for loops to loop through all the shapes in the ShapeList //
            if (i instanceof Quadrilateral3D) { // Checks if the element is a 3D Shape (Quadrilateral3D since in the test file it is instantiated as a Quadrilateral3D for 3D shapes //
                shapes3d.add(i);  // Adds into the ShapeList that only contains 3D Shapes //
            }
        }
        return shapes3d;
    }

    /**Prints out the table format as showed in the pdf of the assignment*/
    public void printFormatted() {
        System.out.printf("+--------+-------------+---------+-------------------------+----------------------+");
        System.out.printf("%n%s %-6s %s %-11s %s %-7s %s %-23s %s %-20s %s","|", "ID", "|" , "Name", "|", "Color", "|", "Dimensions", "|", "Description", "|");
        System.out.printf("%n%s", "+--------+-------------+---------+-------------------------+----------------------+");
        for (Shape i : this) {
            String a = i.toString();
            String b[] = a.split(" ");
            if (i instanceof Quadrilateral) {
                System.out.printf("%n%s %-6s %s %-11s %s %-7s %s", "|", b[0], "|" , b[1], "|", b[2], "|");
                String space = String.format(" %s %s %s", b[3], b[4], b[5]);
                System.out.printf(space);
                for (int j = 0;j < (24-space.length());j++) { System.out.printf(" "); }
                String space2 = String.format(" %s %s %s %s", "|", b[6], b[7], b[8]);
                System.out.printf(space2);
                for (int j = 0;j < (24-space2.length());j++) { System.out.printf(" "); }
                System.out.printf("|");
            } else if (i instanceof Quadrilateral3D) {
                System.out.printf("%n%s %-6s %s %-11s %s %-7s %s", "|", b[0], "|" , b[1], "|", b[2], "|");
                String space = String.format(" %s %s %s %s %s", b[3], b[4], b[5], b[6], b[7]);
                System.out.printf(space);
                for (int j = 0;j < (24-space.length());j++) { System.out.printf(" "); }
                String space2 = String.format(" %s %s %s %s", "|", b[8], b[9], b[10]);
                System.out.printf(space2);
                for (int j = 0;j < (24-space2.length());j++) { System.out.printf(" "); }
                System.out.printf("|");
            }
            System.out.printf("%n%s", "+--------+-------------+---------+-------------------------+----------------------+");
        }
    }

    /**Gets the size of the current instance's size
     * @return returns the size of the ShapeList(by using the size() function from TreeSet)*/
    public int getSize() { return super.size(); }
}