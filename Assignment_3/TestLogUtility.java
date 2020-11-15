package CS_221; /*Created by Azwad Shameem*/

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

public class TestLogUtility {

    private static final String fileName = "Network.log";

    private static final String SEPARATOR = String.format("%130s", " ").replaceAll(" ", "-");

    public static void main(String[] args) {

        System.out.println("Instantiating CS_221.LogUtility");

        LogUtility logUtility = new LogUtility();

        System.out.println(logUtility.toString());

        System.out.println(SEPARATOR);

        try {

            logUtility.parseFile("C:\\Users\\Gamin\\IdeaProjects\\Assignment 3 - CS 221\\src\\Network.log");

            System.out.println(SEPARATOR);

            System.out.println(logUtility.toString());

            System.out.println(SEPARATOR);

            System.out.print("First record with id 1: ");
            System.out.println(logUtility.findFirstId("4276"));

            System.out.print("First record with id 9: ");
            System.out.println(logUtility.findFirstSourceIP("192.168.5.163"));

            System.out.println(SEPARATOR);

            ArrayList<LogEntry> list = logUtility.getBetween("1/1/2019 00:00:00", "12/31/2019 23:59:59");

            System.out.println(String.format("There are %,d entries from 2019", list.size()));
        } catch (FileNotFoundException ex) {
            System.out.printf("Failed to load file: %s%n", new File(fileName).getAbsoluteFile());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}