package CS_221; /*Created by Azwad Shameem*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**This class is where the file is read and if valid are put into a ArrayList of CS_221.LogEntry. In addition this class also cycles through its arraylist to find specific lines by the Find functions*/
public class LogUtility {
    private final ArrayList<LogEntry> listLogEntries;

    /**The Constructor creates an ArrayList of CS_221.LogEntry so that we can store the 7 fields of CS_221.LogEntry into each element of the ArrayList*/
    public LogUtility(){
        listLogEntries = new ArrayList<LogEntry>();
    }

    /**The function parseFile scans the file reads all lines from the provided text file Network.log The method extracts a line from the text
     * file, parses the line by the comma delimiter, and creates a CS_221.LogEntry instance. If the instance is created
     * successfully, the instance is added to the ArrayList ListLogEntry. If an exception is raised from the CS_221.LogEntry, the constructor
     * prints the message: Skipping line: 'Line being skipped'
     * @param fileName  takes the filename and scans the filename line by line
     * @return true this returns true to show it passed only after scanning every line in the file
     * @throws FileNotFoundException if file does not exist throw exception*/
    public boolean parseFile(String fileName) throws FileNotFoundException {
        //Creates a scanner object and a FileInputStream to open the file //
        Scanner reader = new Scanner(new FileInputStream(fileName));
        //The first line of Network.log has an error because it uses an "#" so we skip that line and prints it//
        String s = reader.nextLine();
        System.out.printf("%s%s","Skipping line: ", s);
        //While there is another line in the file keep reading and split the line into 7 fields so that we can input it into an CS_221.LogEntry instance by using the CS_221.LogEntry constructor//
        while (reader.hasNextLine()) {
            String parameters = reader.nextLine();
            String a[] = parameters.split(",");
            try {
                listLogEntries.add(new LogEntry(a[0], a[1], a[2], a[3], a[4], a[5], a[6]));
                //If there is an error in the line that does not follow the restrictions of the CS_221.LogEntry fields then catch an InstantiationException and print that you are skipping the line//
            } catch (InstantiationException ex1) {
                System.out.printf("%n%s%s", "Skipping line: ", parameters);
            }
        }
        //Skips a line so that the output is in the same format as the pdf representation of figure 2//
        System.out.println();
        //Manually closes input to save space//
        reader.close();
        return true;
    }

    /**getBetween makes a list of records between the date string parameters (inclusive).
     * To do this we convert the parameters from String to Date in order to perform the search. Then in the search we loop through all the entries of listLogEntries and use the function compareTo to see if the date is in between
     * @param date1 input date to find in between of with date2
     * @param date2 other input date to find in between of with date1
     * @return answer returns answer, which is a list of records between the date string parameters (inclusive). The two parameters are the start and end dates respectively. First, convert the parameters from String to Date in order to perform the search. ParseException should be handled by this method
     * @throws ParseException if there is an parsing error turning the inputted string into a Date then throw the exception*/
    public ArrayList<LogEntry> getBetween(String date1, String date2) throws ParseException {
        //Creates an arraylist in order to put all the lines that are skipped as an element each//
        ArrayList<LogEntry> answer = new ArrayList<>();
        //SimpleDateFormat formatter formats the parameter dates as a Date//
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date before = formatter.parse(date1);
        Date after = formatter.parse(date2);

        //Since we made the dates into a Date we can now compare them//
        //If there is no dates between the two Date than we can return null//
        if (before.compareTo(after) == 0) {
            return null;
            //Here if the before Date is after the After Date than switch the dates so that before is before and after is after//
        } else if (before.compareTo(after) > 0) {
            Date placeholder = after;
            after = before;
            before = after;
        }
        //Now we can compare for how many dateTime fields in listLogEntries that are in between the Date before and Date After inclusive, by using the compareTo function.//
        //So just add each date as a element of the arraylist answer and return answer to get all the dates in between//
        if (before.compareTo(after) < 0) {
            for (LogEntry date: listLogEntries)
            {
                if (date.getDateTimeAsDate().compareTo(before) >= 0 && date.getDateTimeAsDate().compareTo(after) <= 0) {
                    answer.add(date);
                }
            }
        }
        return answer;
    }

    /**findFirstID calls the common function to find the first line with the input sequence matching the sequence of the line
     * @param Sequence takes a string input called Sequence and to use in the call of the common function to find the first listLogEntry with the same value as the sequence input
     * @return returns the first line that matches the input sequence otherwise return null*/
    public LogEntry findFirstId(String Sequence){ return common(Sequence, Parameter.Sequence); }

    /**findFirstTimeStamp calls the common function to find the first line with the input DateTime matching the sequence of the line
     * @param DateTime takes a string input called DateTime and to use in the call of the common function to find the first listLogEntry with the same value as the DateTime input
     * @return returns the first line that matches the input DateTime otherwise return null*/
    public LogEntry findFirstTimeStamp(String DateTime){ return common(DateTime, Parameter.Datetime); }

    /**findFirstSourceIP calls the common function to find the first line with the input SourceIP matching the sequence of the line
     * @param SourceIP takes a string input called SourceIP and to use in the call of the common function to find the first listLogEntry with the same value as the SourceIP input
     * @return returns the first line that matches the input SourceIP otherwise return null*/
    public LogEntry findFirstSourceIP(String SourceIP) { return common(SourceIP, Parameter.SourceIP); }

    /**findFirstDestinationIP calls the common function to find the first line with the input DestinationIP matching the sequence of the line
     * @param DestinationIP takes a string input called DestinationIP and to use in the call of the common function to find the first listLogEntry with the same value as the DestinationIP input
     * @return returns the first line that matches the input DestinationIP otherwise return null*/
    public LogEntry findFirstDestinationIP(String DestinationIP) { return common(DestinationIP, Parameter.DestinationIP); }

    /**findFirstProtcol calls the common function to find the first line with the input Protocol matching the sequence of the line
     * @param Protocol takes a string input called Protocol and to use in the call of the common function to find the first listLogEntry with the same value as the Protocol input
     * @return returns the first line that matches the input Protocol otherwise return null*/
    public LogEntry findFirstProtocol(String Protocol) { return common(Protocol, Parameter.Protocol); }

    /** findFirstLength calls the common function to find the first line with the input PacketSize matching the sequence of the line
     * @param PacketSize a string input called PacketSize and to use in the call of the common function to find the first listLogEntry with the same value as the PacketSize input
     * @return returns the first line that matches the input PacketSize otherwise return null*/
    public LogEntry findFirstLength(String PacketSize) { return common(PacketSize, Parameter.PacketSize); }

    /**findFirstDescription calls the common function to find the first line with the input Description matching the sequence of the line
     * @param Description a string input called Description and to use in the call of the common function to find the first listLogEntry with the same value as the Description input
     * @return returns the first line that matches the input Description otherwise return null*/
    public LogEntry findFirstDescription(String Description) { return common(Description, Parameter.Comment); }

    /**An enum function to be used as a parameter in the common function for the findFirst functions*/
    private enum Parameter {
        Sequence,
        Datetime,
        SourceIP,
        DestinationIP,
        Protocol,
        PacketSize,
        Comment;
    }

    /**This is the common function it is called in any of the 7 findFirst functions. This function shares the common logic between all the findFirst functions so that it does not need
     * to be repeated. As a result we can call any one of the findFirst functions but still have the ability to return exactly the first occurance of whatever findFirst function is called into common.
     * @param value the String value that needs to be matched
     * @param parameter each parameter is listed in their respective findFirst function and correlates with the p values in the switch function below which picks the right portion of the split line
     * @return listLogEntries.get(i) which is the specific line that was found to be the first line that has its specific portion matching the string value*/
    public LogEntry common(String value, Parameter parameter) {
        int p = 0;
        //Declares the value of p so that depending on which firstFind function is called we still pick the right portion of the line that was split//
        switch (parameter) {
            case Sequence:
                p = 0;
                break;
            case Datetime:
                p = 1;
                break;
            case SourceIP:
                p = 2;
                break;
            case DestinationIP:
                p = 3;
                break;
            case Protocol:
                p = 4;
                break;
            case Comment:
                p = 5;
                break;
            case PacketSize:
                p = 6;
                break;
        }
        //Here is the common logic of the findFirst functions, we go through all the listLogEntries and split each line by "," then select the p part of that line.//
        //The p is the value of whatever enum parameter is called in one of the 7 findFirst functions, the arrangement of the value p that specifies to one of the 7 fields of CS_221.LogEntry so now we can just call on the p section of the line//
        //returns the line in listLogEntries that matches the string input parameter//
        for (int i = 0, n = listLogEntries.size(); i < n; ++i) {
            if (listLogEntries.get(i).toString().split(",")[p].equals(value)) { return listLogEntries.get(i); }
        }
        //If the string input parameter does not exist in listLogEntries return null//
        return null;
    }
    /**Returns the size of listLogEntries*/
    public String toString() { return String.format("CS_221.LogUtility: there are %d records", listLogEntries.size()); }
}
