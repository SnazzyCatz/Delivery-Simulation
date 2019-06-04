/**
 * This class creates a delivery list node which will be put into the link list and contain
 * the delivery information
 * @author Michel Fasano
 * michael.fasano@stonybrook.edu
 * 110798138
 *
 */
public class DeliveryListNode {
	private Delivery data;
	private DeliveryListNode next;
	private DeliveryListNode prev;
	/**
	 * This creates a default delivery list node that takes a delivery as a parameter with data
	 * @param initData
	 */
	public DeliveryListNode(Delivery initData) {
		this.data = initData;
		if(initData == null) {
			throw new IllegalArgumentException();
		}
		prev = null;
		next = null;
	}
	/**
	 * This gets the information of the delivery
	 * @return Delivery
	 * 		This method returns a Delivery's data
	 */
	public Delivery getData() {
		return data;
	}
	/**
	 * This method sets the data of the delivery 
	 * @param data
	 * 		This method sets the data of the delivery object
	 */
	public void setData(Delivery data) {
		this.data = data;
	}
	/**
	 * This method returns the next delivery in the list
	 * @return DeliveryListNode
	 * 		This gives you the next delivery in the link list
	 */
	public DeliveryListNode getNext() {
		return next;
	}
	/**
	 * This method sets the next delivery in the list
	 * @param next
	 * 		This method allows you to assign the next delivery in the list
	 */		
	public void setNext(DeliveryListNode next) {
		this.next = next;
	}
	/**
	 * This method returns the previous delivery in the list
	 * @return DeliveryListNode
	 * 		This gives you whatever the previous delivery was and its info
	 */
	public DeliveryListNode getPrev() {
		return prev;
	}
	/**
	 * This method sets the previous delivery to whatever you choose
	 * @param prev
	 * 		This allows you to assign something to the previous delivery in the list
	 */
	public void setPrev(DeliveryListNode prev) {
		this.prev = prev;
	}
}
