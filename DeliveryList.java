/**
 * This class creates the delivery list made of a link list
 * 
 * @author Michael Fasano 
 * michael.fasano@stonybrook.edu 
 * 110798138
 *
 */
public class DeliveryList {
	private DeliveryListNode head;
	private DeliveryListNode tail;
	private DeliveryListNode cursor;
	private int counter = 0;

	/**
	 * This method creates a default delivery list and initializes it values to
	 * null
	 */
	public DeliveryList() {
		head = null;
		tail = null;
		cursor = null;
	}
	/**
	 * This method returns the delivery list node at the front of the list(the head)
	 * @return DeliveryListNode
	 * 		This gives you the head of the list
	 */
	public DeliveryListNode getHead() {
		return head;
	}
	/**
	 * This method sets the head to another delivery list node
	 * @param head
	 * 		This sets the head to a new node
	 */
	public void setHead(DeliveryListNode head) {
		this.head = head;
	}
	/**
	 * This method returns the last node in the delivery list
	 * @return DeliveryListNode
	 * 		This gives you the tail of the list
	 */
	public DeliveryListNode getTail() {
		return tail;
	}
	/**
	 * This method sets the tail to another delivery list node
	 * @param tail
	 * 		This sets the tail to the new node
	 */
	public void setTail(DeliveryListNode tail) {
		this.tail = tail;
	}
	/**
	 * This method returns the counter that keeps track of the size of the link list
	 * @return int
	 * 		This gives you the list size
	 */
	public int getCounter() {
		return counter;
	}
	/**
	 * This method sets the counter (even though it should be 0 from the start in this case)
	 * @param counter
	 * 		This sets the counter to the size of the link list if there were already things in it
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}
	/**
	 * This method sets the cursor to some node in the list
	 * @param cursor
	 * 		This sets the cursor reference to the given parameter
	 */
	public void setCursor(DeliveryListNode cursor) {
		this.cursor = cursor;
	}

	/**
	 * This method returns an integer containing the amount of deliveries
	 * 
	 * @return int This method tells you how many deliveries are in the list
	 */
	public int numDeliveries() {
		return counter;
	}

	/**
	 * This method returns a delivery object that is located at cursor in the
	 * link list
	 * 
	 * @return Delivery This gives you the object at the cursor
	 */
	public Delivery getCursor() {
		if (cursor == null) {
			return null;
		}
		while (cursor != null) {
			cursor = cursor.getNext();
		}
		return cursor.getData();
	}
	/**
	 * This gives you node that the cursor is pointing to
	 * @return DeliveryListNode
	 * 		This gives you the cursors reference
	 */
	public DeliveryListNode getCursorNode() {
		return cursor;
	}
	/**
	 * This method resets the cursor to the head so you can go through the link
	 * list from the start
	 */
	public void resetCursorToHead() {
		if (head != null) {
			cursor = head;
		}
		if (head == null) {
			cursor = null;
		}
	}
	/**
	 * This method resets the cursor to the head so you can go through the link list
	 * starting from the back
	 */
	public void resetCursorToTail() {
		if(tail != null) {
			cursor = tail;
		}
		if(head == null) {
			cursor = null;
		}
	}
	/**
	 * This method moves the cursor one point forward in the list and throws an
	 * error if you try to move the right of the end of the tail into null
	 * territory
	 * 
	 * @throws EndOfListException
	 *             An error is thrown when trying to move into null territory
	 */
	public void cursorForward() throws EndOfListException {
		if (cursor == tail) {
			throw new EndOfListException("There is No Link Past This Point");
		} else {
			cursor = cursor.getNext();
		}
	}

	/**
	 * This method moves the cursor backwards and throws an error if you try to
	 * move to the left of the head of the list since there is nothing there
	 * 
	 * @throws EndOfListException
	 *             An error is thrown when trying to move left into null space
	 */
	public void cursorBackward() throws EndOfListException {
		if (cursor == head) {
			throw new EndOfListException("There is No Link Made Before This Point");
		} else {
			cursor = cursor.getPrev();
		}
	}

	/**
	 * This method inserts a new delivery into the link list and throws an error
	 * if the parameter is null. It also increments the counter by 1 if
	 * successful
	 * 
	 * @param newDelivery
	 *            A new delivery parameter is taken to be put into the link list
	 *            at the point after the cursor
	 */
	public void insertAfterCursor(Delivery newDelivery) {
		DeliveryListNode newNode = new DeliveryListNode(newDelivery);
		if (newDelivery == null) {
			throw new IllegalArgumentException();
		}
		//if it's empty does this
		if(cursor == null) {
			head = newNode;
			tail = newNode;
			cursor = newNode;
			counter++;
		}
		else {
		newNode.setPrev(cursor);
		newNode.setNext(cursor.getNext());
		try {
		cursor.getNext().setPrev(newNode);
		}catch(Exception e) {
		}
		newNode.getPrev().setNext(newNode);
		cursor = newNode;
		if(newNode.getNext() == null) {
			tail = newNode;
		}
		counter++;
		}
	}

	/**
	 * This method adds a new delivery to the tail of the link list and throws
	 * an exception if the delivery object is null. This also increments counter
	 * by 1 if successful
	 * 
	 * @param newDelivery
	 *            This method takes a new delivery parameter and puts it at the
	 *            end
	 */
	public void appendToTail(Delivery newDelivery) {
		if (newDelivery == null) {
			throw new IllegalArgumentException();
		}
		DeliveryListNode newNode = new DeliveryListNode(newDelivery);
		if(tail == null) {
			cursor = newNode;
			tail = newNode;
			head = newNode;
		}
		cursor = tail;
		cursor.setNext(newNode);
		newNode.setPrev(cursor);
		newNode.setNext(null);
		tail = newNode;
		cursor = newNode;
		counter++;
	}

	/**
	 * This method removes the delivery at the cursors location and then returns
	 * the delivery object of what was removed. It also throws an exception if
	 * you try to remove a delivery that isn't there. Counter is decremented if
	 * the delivery at cursor is successfully removed
	 * 
	 * @return Delivery This returns the deleted delivery
	 * @throws EndOfListException
	 */
	public Delivery removeCursor() throws EndOfListException {
		if (cursor == null) {
			throw new EndOfListException("There Is No List At This Position");
		}
		DeliveryListNode removedNode = cursor;
		if(cursor == tail) {
			cursor.getPrev().setNext(null);
			tail = cursor.getPrev();
			cursor = tail;
			counter--;
		}
		else if(cursor == head) {
			cursor.getNext().setPrev(null);
			head = cursor.getNext();
			cursor = head;
			counter--;
		}
		else {
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursor.getPrev());
			cursor = cursor.getNext();
			counter--;
		}
		return removedNode.getData();
	}
	/**
	 * This returns a string with the contents of the link list
	 * @return String
	 * 		This gives you the contents of the list
	 */
	public String toString() {
		DeliveryListNode temp = head;
		StringBuilder meme = new StringBuilder();
		if(counter == 1) {
			meme.append(temp.getData());
			return meme.toString();
		}
		else {
		do {
			meme.append(temp.getData()).append("\n");
			temp = temp.getNext();
		}
		while(temp.getNext() != null);
		meme.append(this.getTail().getData());
		return meme.toString();
		}
	}
}
