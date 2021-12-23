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
 * An array implementation of stacks
 * @author noah
 *
 */

public class UAStackArray {
	/**
	 * Stack class that will be implementing an array
	 */
	int top = -1;
	int size;
	UAStudent[] array;
	int i = 0;
	
	/**
	 * Constructor for the UAStackArray class that initializes the array from the parameter
	 * @param size size being assigned for initialization of array
	 */
	public UAStackArray(int size) {
		array = new UAStudent[size];
	}
	/**
	 * Pushes an Object UAStudent "s" onto the stack resizing when needed and incrementing size field
	 * This method runs in O(n)
	 * @param s Object being pushed onto stack
	 */
	public void push(UAStudent s) {
		if(top == (size-1)) {
			resize();
		}
		if(s != null) {
			
			top++;
			array[top] = s;
		}
		size++;
	}
	/**
	 * Pops an Object off the stack and decrementing the size field
	 * This method runs in O(1)
	 * @return temp the object holding the top's original value
	 */
	public UAStudent pop() {

		UAStudent temp = array[top];
		if(top != 0) {
			array[top] = null;
			top--;
		}
		size--;
		return temp;
	}
	/**
	 * simply returns the current size of stack
	 * This method runs in O(1)
	 * @return size
	 */
	public int size() {
		return size;
	}
	/**
	 * returns a boolean depending on whether or not an items are currently on the stack
	 * This method runs in O(1)
	 * @return size==0 boolean being returned
	 */
	public boolean isStackEmpty() {
		return size == 0;
	}
	/**
	 * method that will resize the array at its worse case when the size reaches the array length
	 * This method runs in O(n)
	 */
	public void resize() {
		UAStudent[] newArray = new UAStudent[(int) Math.ceil(array.length * 1.5)];
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}
	
	

	public static class UAStudent {
		
		private int studentId;
		private String firstName;
		private String lastName;
		
		/**
		 * Constructor for the UAStudent class that streamlines insert the initial data into the stack from records.txt
		 * @param input UAStudent data being read from records.txt
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
	
	
	public static void main(String[] args) throws IOException {

		UAStackArray st = new UAStackArray(100);

		BufferedReader br = new BufferedReader(new FileReader("Records.txt"));
		
		String line = "";
		
		while((line = br.readLine()) != null) {
			
			
			
			st.push(new UAStudent(line));
		}

		System.out.println("=== Start ==============================");
		System.out.println("Size of Stack:  " + st.size() );
		
		System.out.println("\n\n");
		System.out.println("=== Inserts ==============================");

		UAStudent a = new UAStudent("Mackey,Andrew,44444");
		st.push( a );	
		st.push( new UAStudent("Mackey,Andrew,55555") );
		st.push( new UAStudent("Mackey,Andrew,99999") );
		
		System.out.println("Size of Stack:  " + st.size() );
		
		System.out.println("\n\n");
		System.out.println("=== Deletes ==============================");	
		System.out.println(st.pop());
		System.out.println(st.pop());
		
		System.out.println("Size of Stack:  " + st.size() );
		
		System.out.println(st.pop());
		
		System.out.println("Size of Stack:  " + st.size() );
		
		br.close();
	}

	


}