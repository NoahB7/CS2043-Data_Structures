import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/********************************
Name: Noah Buchanan
Username: ua203
Problem Set: PS6
Due Date: July 12, 2020
********************************/

/**
 * A linked list implementation of stacks
 * @author noah
 *
 */
public class UAStackLinkedList {
	/**
	 * Stack class that will be implementing a linked list
	 */
	UAStudent top;
	int size;
	
	/**
	 * Pushes an object onto the stack and makes it the new top of the stack
	 * This method runs in O(1)
	 * @param s Object being pushed onto stack
	 */
	public void push(UAStudent s) {
		
		if(s != null) {
			s.next = top;
			top = s;
			size++;
		} 
	}
	/**
	 * Pops the top object off of the stack and moves the top of the stack to the previous object
	 * This method runs in O(1)
	 * @return temp a holder for what the top previously was to return what was popped off
	 */
	public UAStudent pop() {
		UAStudent temp = top;
		if(top != null) {
			top = top.next;
			temp.next = null;
			size--;
		}
		return temp;
	}
	/**
	 * returns the size of the current stack
	 * This method runs in O(1)
	 * @return size size of stack
	 */
	public int size() {
		return size;
	}
	/**
	 * returns true or false depending on whether or not the stack is empty
	 * This method runs in O(1)
	 * @return size==0 the boolean returned based on if the stack is empty or not
	 */
	public boolean isStackEmpty() {
		return size == 0;
	}

	public static class UAStudent {

		private int studentId;
		private String firstName;
		private String lastName;
		UAStudent next;
		/**
		 * constructor for the UAStudent class to streamline data input onto the stack
		 * @param input the line read from records.txt that will be turned into a UAStudent object and pushed onto the stack
		 */
		public UAStudent(String input) {
			String[] x = input.split(",");
			
			this.firstName = x[0];
			this.lastName = x[1];
			this.studentId = Integer.parseInt(x[2]);
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

	public static void main(String[] args)throws IOException {

		UAStackLinkedList st = new UAStackLinkedList();

		BufferedReader br = new BufferedReader(new FileReader("Records.txt"));

		String line = "";

		while ((line = br.readLine()) != null) {

			st.push(new UAStudent(line));
		}

		System.out.println("=== Start ==============================");
		System.out.println("Size of Stack:  " + st.size());

		System.out.println("\n\n");
		System.out.println("=== Inserts ==============================");

		UAStudent a = new UAStudent("Mackey,Andrew,44444");
		st.push(a);
		st.push(new UAStudent("Mackey,Andrew,55555"));
		st.push(new UAStudent("Mackey,Andrew,99999"));

		System.out.println("Size of Stack:  " + st.size());

		System.out.println("\n\n");
		System.out.println("=== Deletes ==============================");
		System.out.println(st.pop());
		System.out.println(st.pop());

		System.out.println("Size of Stack:  " + st.size());

		System.out.println(st.pop());

		System.out.println("Size of Stack:  " + st.size());
		
		br.close();

	}

}