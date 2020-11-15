package CS_221; /*Created by Azwad Shameem*/

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A4Test {

    // Modify the path if needed
    public final static String FILE_NAME = "TestShapes.txt";

    public static void main(String[] args) throws Exception {

        // ensure file is accessible
        if (!new File(FILE_NAME).exists())
            throw new FileNotFoundException(String.format("Input file not found in the program's classpath. Copy the file into the class' path of adjust the file's path.%nFile Path: %s", new File(FILE_NAME).getAbsolutePath()));

        ShapeList shapeList = new ShapeList();

        Scanner scanner = new Scanner(new File(FILE_NAME));

        // skip file header
        String line = scanner.nextLine();

        while (scanner.hasNextLine()) {

            boolean result = false;
            Shape shape = null;

            line = scanner.nextLine();

            String[] lineParts = line.split(",");

            String[] dimensions = lineParts[2].split(":");

            try {

                switch (lineParts[3].toLowerCase()) {

                    case "rectangle":
                        shape = new Quadrilateral(Integer.parseInt(lineParts[0]), lineParts[3], lineParts[4], getColor(lineParts[1]), Double.parseDouble(dimensions[0]), Double.parseDouble(dimensions[1]));
                        break;
                    case "square":
                        shape = new Quadrilateral(Integer.parseInt(lineParts[0]), lineParts[3], lineParts[4], getColor(lineParts[1]), Double.parseDouble(dimensions[0]), Double.parseDouble(dimensions[1]));
                        break;
                    case "cuboid":
                        shape = new Quadrilateral3D(Integer.parseInt(lineParts[0]), lineParts[3], lineParts[4], getColor(lineParts[1]), Double.parseDouble(dimensions[0]), Double.parseDouble(dimensions[1]), Double.parseDouble(dimensions[2]));
                        break;
                    case "cube":
                        shape = new Quadrilateral3D(Integer.parseInt(lineParts[0]), lineParts[3], lineParts[4], getColor(lineParts[1]), Double.parseDouble(dimensions[0]), Double.parseDouble(dimensions[1]), Double.parseDouble(dimensions[2]));
                        break;
                    default:
                        throw new UnsupportedOperationException(String.format("Unrecognized shape, skipping: %s", line));
                }

                if (shape != null && !shapeList.add(shape))
                    throw new UnsupportedOperationException("Duplicate shape, skipping: " + line);

            } catch (UnsupportedOperationException ex) {
                System.err.println(ex);
                continue;
            }
        }

        scanner.close();

        System.out.printf("The list contains %d Shape objects%n", shapeList.getSize());

        ShapeList set2D = shapeList.get2DShapes();
        System.out.printf("There are %d 2-Dimensional shapes%n", set2D.size());

        ShapeList set3D = shapeList.get3DShapes();
        System.out.printf("There are %d 3-Dimensional shapes%n", set3D.size());

        shapeList.printFormatted();

    }

    private static Color getColor(String strColor) {
        switch (strColor.toLowerCase()) {
            case "black":
                return Color.BLACK;
            case "blue":
                return Color.BLUE;
            case "green":
                return Color.GREEN;
            case "red":
                return Color.RED;
            case "white":
                return Color.WHITE;
            case "cyan":
                return Color.CYAN;
            case "yellow":
                return Color.YELLOW;
        }

        return null;
    }
}