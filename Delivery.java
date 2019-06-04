/**
 * This class makes a delivery object which is stored as a node in a link list and methods 
 * to edit the delivery are provided here
 * @author Michael Fasano
 * michael.fasano@stonybrook.edu
 * 110798138
 */
public class Delivery {
	private String source;
	private String dest;
	private String instruction;
	/**
	 * This creates a default delivery object 
	 */
	public Delivery() {
		source = "";
		dest = "";
		instruction = "";
	}
	public Delivery(String source, String dest, String instruction) {
		this.source = source;
		this.dest = dest;
		this.instruction = instruction;
	}
	/**
	 * This method gets the source of the delivery
	 * @return String
	 * 		This method returns a string containing the source of the delivery
	 */
	public String getSource() {
		return source;
	}
	/**
	 * This method sets a new source 
	 * @param source
	 * 		This method sets the source to whatever the string parameter is
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * This method gets the destination of the delivery
	 * @return String
	 * 		This method returns a string containing the destination of the delivery
	 */		
	public String getDest() {
		return dest;
	}
	/**
	 * This method sets the destination of the delivery
	 * @param dest
	 * 		This method sets the destination to whatever the string parameter is
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}
	/**
	 * This method gets the instructions for the delivery in the form of a string
	 * @return String
	 * 		This method returns a string containing the instructions of the delivery
	 */
	public String getInstruction() {
		return instruction;
	}
	/**
	 * This method sets the instructions for the delivery in the form of a string
	 * @param instruction
	 * 		This method sets the instructions to whatever the string contains
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	/**
	 * This method returns a string containing a combination of all the delivery variables,
	 * source, dest, and instruction
	 * @return String
	 */
	public String toString() {
		return("Source:" + source + "\nDestination:" + dest + "\nInstruction:" + instruction);
	}
}
