import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Linked list implementation of a queue using generics
 * @author noah
 * 
 */
public class UAQueueLinkedList<T> {

	/********************************
	 * Name: Noah Buchanan 
	 * Username: ua203 
	 * Problem Set: PS7 
	 * Due Date: July 17,2020
	 ********************************/
	
	int size;
	Wrapper<T> head;
	Wrapper<T> tail;
	/**
	 * puts a generic object into the tail of the linkedlist queue
	 * @param s generic object being put into the queue
	 */
	public void enqueue(T s) {

		Wrapper<T> temp = new Wrapper<T>();
		temp.node = s;
		if (tail == null) {
			tail = temp;
			head = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}
		size++;
	}
	/**
	 * removes the generic object at the head of the queue and returns said object
	 * @return temp temp is a placeholder for the head generic object that was removed
	 */
	public T dequeue() {

		T temp = head.node;
		head = head.next;
		size--;
		return temp;
	}
	/**
	 * returns the size of the queue
	 * @return size size of queue
	 */
	public int size() {
		return size;
	}
	/**
	 * returns a boolean depending on if the queue is empty or not
	 * @return size==0 boolean repesenting if the queue is empty
	 */
	public boolean isQueueEmpty() {
		return size == 0;
	}

	public static class UAStudent<T> {

		private int studentId;
		private String firstName;
		private String lastName;

		/**
		 * constructor for UAStudent to make ease of reading in values specifically for UAStudent
		 * @param input line read from file split into different fields respectively
		 */
		public UAStudent(String input) {

			String[] x = input.split(",");

			this.lastName = x[0];
			this.firstName = x[1];
			this.studentId = Integer.parseInt(x[2]);
		}

		public UAStudent() {

		}

		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String toString() {
			return "Student: \t" + lastName + ", " + firstName;
		}

	}

	public static void main(String[] args) throws IOException {

		UAQueueLinkedList<UAStudent> q = new UAQueueLinkedList<UAStudent>();

		BufferedReader br = new BufferedReader(new FileReader("records.txt"));

		String line = "";

		while ((line = br.readLine()) != null) {

			UAStudent x = new UAStudent(line);
			q.enqueue(x);
		}

		System.out.println("=== Start ==============================");
		System.out.println("Size of Queue:  " + q.size());

		System.out.println("\n\n");
		System.out.println("=== Inserts ==============================");

		UAStudent a = new UAStudent("Mackey,Andrew,44444");
		q.enqueue(a);
		q.enqueue(new UAStudent("Mackey,Andrew,55555"));
		q.enqueue(new UAStudent("Mackey,Andrew,99999"));

		System.out.println("Size of Queue:  " + q.size());

		System.out.println("\n\n");
		System.out.println("=== Deletes ==============================");
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		System.out.println("Size of Queue:  " + q.size());

		System.out.println(q.dequeue());

		System.out.println("Size of Queue:  " + q.size());

		System.out.println("\n\n");
		System.out.println("=== Demonstrating Other Types =============");
		UAQueueLinkedList<String> q2 = new UAQueueLinkedList<String>();
		q2.enqueue("test1");
		
		line = "";

		while ((line = br.readLine()) != null) {

			q2.enqueue(line);
		}

		q2.enqueue("test2");

		while (!q2.isQueueEmpty()) {
			System.out.println(q2.dequeue());
		}
		
		System.out.println("End");

	}

}