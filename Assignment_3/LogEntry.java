package CS_221; /*Created by Azwad Shameem*/

import java.text.ParseException; //For the getDateTimeAsDate function if an error occurs when parsing the dateTime string into a date//
import java.text.SimpleDateFormat; //For the getDateTimeAsDate function //
import java.util.Date; //For the getDateTimeAsDate function//

/**This class is an object that stores 7 string values if they are valid*/
public class LogEntry {
    private final String sequence;
    private final String packetSize;
    private final String dateTime;
    private final String sourceIP;
    private final String destinationIP;
    private final String protocol;
    private final String comment;

    /**Constructor for CS_221.LogEntry - initalizes class' fields after validating the information to the
     *  restrictions in the table on the pdf. If any of the values do not conform the restrictions shown
     *  in Figure 1 the constructor throws an exception of type InstantiationException with the
     *  message "One or more values are invalid"
     *  @param sequence --> must exist and be in between 1 and MAX_VALUE
     *  @param dateTime --> must exist and be 19 characters long
     *  @param sourceIP --> must exist and cannot be null
     *  @param destinationIP --> must exist and cannot be null
     *  @param packetSize --> must exist and be in between 1 and 1500
     *  @param protocol --> must exist and be either TCP or UDP
     *  @param comment --> must exist
     *  @throws InstantiationException if the parameters above does not configure to the restrictions written in the pdf*/
    public LogEntry (String sequence, String dateTime, String sourceIP, String destinationIP, String protocol, String packetSize, String comment) throws InstantiationException {
        //The if statement below tests if the values in the file are valid according to the restrictions //
        //First the if statement checks if any of the string value are empty //
        if (sequence.isEmpty() || dateTime.isEmpty() || protocol.isEmpty() || packetSize.isEmpty() || comment.isEmpty()
                //After checking if empty we check if the sequence is a valid integer between 1 and MAX_VALUE//
                || Integer.parseInt(sequence) < 1 || Integer.parseInt(sequence) > Integer.MAX_VALUE //<-- sequence will always be less than MAX_VALUE but i wrote it just in case//
                //After checking sequence we check the length of dateTime//
                ||(dateTime.length() != 19)
                //After dateTime, we check if the SourceIP is accordance with the restriction. We check if its null or empty //
                || (sourceIP == null || sourceIP.isEmpty())
                //Same as dateTime, We check if its null or empty //
                || (destinationIP == null || destinationIP.isEmpty())
                //Now we check protocol and for protocol we need to know if its TCP or UDP.//
                //We can do this by checking the or statement if it is TCP or UDP. If it is TCP or UDP then it is true, so we do the ! sign to make sure it is false so the error isn't thrown//
                //Otherwise if it is not TCP or UDP it will return false and we use the ! sign to return the opposite so it will return true and trigger the error exception//
                || (!( protocol.equals("TCP") || protocol.equals("UDP")))
                //Lastly we check if packetSize is between 1 and 1500//
                || (Integer.parseInt(packetSize) < 1 || Integer.parseInt(packetSize) > 1500)) {
            //If any of the statements above are true, meaning that there an invalid entry, then the below exception will be thrown//
            throw new InstantiationException("One or more values are invalid");
        } else {
            //If all of the statements above are false then there is no invalid entry we will input the values from the parameters into the private variables for this CS_221.LogEntry//
            this.sequence = sequence;
            this.packetSize = packetSize;
            this.dateTime = dateTime;
            this.sourceIP = sourceIP;
            this.destinationIP = destinationIP;
            this.protocol = protocol;
            this.comment = comment;
        }
    }

    /** @return date -> getDateTimeAsDate returns the value of dateTime field as a Date object.
     * @throws ParseException if there is an error formating the dateTime String into a Date then throw an error*/
    public Date getDateTimeAsDate() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = formatter.parse(getDateTime());
        return date;
    }

    /**toString returns a comma delimited string consisting of the class' 7 fields*/
    public String toString() {
        // formats all the class' fields into a multi line string in the order that figure 2 on the pdf shows //
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                getSequence(), getDateTime(), getSourceIP(), getDestinationIP(),
                getProtocol(), getComment(), getPacketSize());
    }

    /**@return this.sequence --> getSequence returns the string value of sequence */
    public String getSequence(){ return this.sequence; }
    /**@return this.packetSize --> getPacketSize returns the string value of packetSize*/
    public String getPacketSize(){ return this.packetSize; }
    /**@return dateTime --> getDateTime returns the string value of dateTime*/
    public String getDateTime() { return this.dateTime; }
    /**@return this.sourceIP --> getSourceIP returns the string value of sourceIP*/
    public String getSourceIP() { return this.sourceIP; }
    /**@return this.destinationIP --> getDestinationIP returns the string value of DestinationIP*/
    public String getDestinationIP() { return this.destinationIP; }
    /**@return this.protocol--> getProtocol returns the string value of protocol*/
    public String getProtocol() { return this.protocol; }
    /**@return this.comment --> getComment returns the string value of comment*/
    public String getComment() { return this.comment; }

}
