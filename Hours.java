public class Hours {

    final static int MINUTES_PER_HOUR = 60;
    final static int SECONDS_PER_MINUTE = 60;

    /**
     * Given a number of hours, return the number of seconds that
     * would be equivalent to that number of hours.
     */
    
    public static double calculateSeconds(double hours) {
	return hours * MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
    }

    /**
     * Given a double representing the number of hours as the first
     * argument on the command line, this will print out the number
     * of seconds in that number of hours.  
     * For example, 1 hour = 3600.0 seconds.
     * Additional arguments from the command line are ignored.
     */
    
    public static void main(String[] args) {
	double numHours = -1;
	try {
	    numHours = Double.parseDouble(args[0]);
	} catch (NumberFormatException nfex) {
	    // The argument passed in could not be parsed
	    System.exit(1);
	} catch (ArrayIndexOutOfBoundsException oobex) {
	    // No argument was passed in
	    System.exit(1);
	}
	System.out.println(calculateSeconds(numHours) + " seconds");
	
    }
    
}
