import java.util.*;
/**
 * This is the driver class that uses all the helper classes
 * @author Michael Fasano
 * michael.fasano@stonybrook.edu
 * 110798138
 *
 */
public class DeliveryDriver {
	private static DeliveryList a = new DeliveryList();
	private static DeliveryList b = new DeliveryList();
	private static DeliveryList c = a;
	private static Delivery temp = new Delivery();
	private static String exit = "";
	private static String option = "";
	/**
	 * A - Add Delivery After Cursor
	 * H - Cursor to Head
	 * T - Cursor to Tail
	 * F - Cursor Forward
	 * B - Cursor Backward
	 * R - Remove Cursor
	 * X - Cut Cursor - This removes the cursor and saves the object in a temp variable
	 * V - Paste After Cursor - This inserts the temp variable from the cut method after the cursor
	 * S - Switch Delivery Route
	 * P - Print Current Delivery Route
	 * Q - Quit
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Thanks For Choosing the Cloud 9 Delivery Scheduler");
		System.out.println(
				"Listed Below Are Your Options For What You Can Do With Your Route:" + "\nA) Add Delivery After Cursor"
						+ "\nH) Cursor to Head" + "\nT) Cursor to Tail" + "\nF) Cursor Forward" + "\nB) Cursor Backward"
						+ "\nR) Remove Cursor" + "\nX) Cut Cursor" + "\nV) Paste After Cursor"
						+ "\nS) Switch Delivery Route" + "\nP) Print Current Delivery Route" + "\nQ) Quit");

		while (!exit.equals("exit")) {
			System.out.println("Please Pick Your Option:");
			option = input.nextLine();
			option = option.toLowerCase();
			switch (option) {
			case "a":
				System.out.println("Please Provide A Source:");
				String source = input.nextLine();
				System.out.println("Please Provide A Destination:");
				String dest = input.nextLine();
				System.out.println("Please Provide Instructions:");
				String instructions = input.nextLine();
				Delivery newDelivery = new Delivery(source, dest, instructions);
				DeliveryListNode newNode = new DeliveryListNode(newDelivery);
				if (c.getHead() == null) {
					c.appendToTail(newDelivery);
				} else {
					c.insertAfterCursor(newDelivery);

				}
				break;

			case "h":
				c.resetCursorToHead();
				System.out.println("The Cursor has been Reset to the Head");
				break;

			case "t":
				c.resetCursorToTail();
				System.out.println("The Cursor has been Reset to the Tail");
				break;

			case "f":
				System.out.println("The Cursor Will Be Moved Forwards");
				try {
					c.cursorForward();
				} catch (EndOfListException e) {
					System.out.println("The Cursor Could Not Be Moved Forwards");
				}
				break;

			case "b":
				System.out.println("The Cursor Will Be Moved Backwards");
				try {
					c.cursorBackward();
				} catch (EndOfListException e) {
					System.out.println("The Cursor Could Not Be Moved Backwards");
				}
				break;

			case "r":
				System.out.println("The Delivery Will Be Removed");
				try {
					c.removeCursor();
				} catch (EndOfListException e) {
					System.out.println("There Is No Delivery In This Spot, Try Another Spot");
				}
				break;

			case "x":
				System.out.println("The Delivery Will Be Removed");
				try {
					temp = c.removeCursor();
				} catch (EndOfListException e) {
					System.out.println("There Is No Delivery In This Spot, Try Another Spot");
				}
				break;

			case "v":
				c.insertAfterCursor(temp);
				break;
			case "s":
				if(c == a) {
				c = b;
				}
				else {
					c = a;
				}
				System.out.println("The Route Has Been Switched");
				break;

			case "p":
				System.out.println(c.toString());
				System.out.println("\nThe Cursor is Currently at:\n" + c.getCursorNode().getData());
				break;

			case "q":
				System.out.println("Thank's for using Cloud 9 Delivery Service Boss");
				exit = "exit";
				break;
			}
		}
	}
}
