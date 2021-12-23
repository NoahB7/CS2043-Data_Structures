/**
	 * Wrapper class for UAQueueLinkedList utilizing a node of generic type for the enqueue() method in 
	 * UAQueueLinkedList and a next field to create the linked list with any object
	 */
public class Wrapper<T> {
	/**
	 * Generic node object used enqueue method and next used for Linked List
	 */
	T node;
	Wrapper<T> next;

}
