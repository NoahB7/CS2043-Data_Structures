import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/***********************************************************************************
 * Student Name: Noah Buchanan Date: July 20,2020 Class: Data Structures
 * Filename: UAHashTable.java Description: Implementation of a hash table (by A.
 * Mackey)
 ***********************************************************************************/

public class UAHashTable {

	protected static final int INITIAL_SIZE = 27;
	protected UACourse[] T;
	protected int hashMapSize;
	protected int collisionCount;

	/*
	 * Constructors
	 */

	public UAHashTable(int size) {
		T = new UACourse[size];
	}

	public UAHashTable() {
		this(INITIAL_SIZE);
	}

	/*
	 * Methods to implement in each class: insert() and search()
	 */

	public void readFile(String filename) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(filename));

		String line = "";

		while ((line = br.readLine()) != null) {

			String[] x = line.split(",");

			insert(new UACourse(Integer.parseInt(x[0]), x[1], x[2]));
		}
		br.close();

	}
	
	public void resize() {
		UACourse[] a = T;
		UACourse[] b = new UACourse[(T.length * 2 + 7)];
		T = b;
		int hold = collisionCount;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] != null) {
				
				insert(a[i]);
				
				hashMapSize--;
				if(hold != collisionCount) {
					collisionCount = hold;
				}
				
			}
		}
	}

	public void printMap() {

		for (int i = 0; i < T.length; i++) {

			if (T[i] == null) {
				System.out.println("EMPTY");
			} else {
				System.out.print(T[i]);
			}
		}
	}

	public void insert(UACourse k) {

	}

	public UACourse search(int id) {
		return null;
	}

	public int size() {
		return hashMapSize;
	}

	// This should return the number of times a collision occurred.

	public int getCollisionCount() {
		return this.collisionCount;
	}

	/*
	 * Runtime code
	 */

	public static void main(String[] args) throws IOException {

		if (args.length > 1) {

			if (args[1].equals("linear")) {

				UAHashTable x = new UAHashTableLinearProbing();

				x.readFile(args[0]);

				System.out.println(x.getCollisionCount() + "\n");

				x.printMap();
				
				System.out.println("\n" + x.getCollisionCount());
			} else if (args[1].equals("quadratic")) {

				UAHashTable x = new UAHashTableQuadraticProbing();

				x.readFile(args[0]);

				System.out.println(x.getCollisionCount() + "\n");

				x.printMap();
				
				System.out.println("\n" + x.getCollisionCount());
			} else if (args[1].equals("double")) {

				UAHashTable x = new UAHashTableDoubleHashing();

				x.readFile(args[0]);

				System.out.println(x.getCollisionCount() + "\n");

				x.printMap();
				
				System.out.println("\n" + x.getCollisionCount());
			} else {
				System.out.println("Open addressing method not specified");
			}
		} else {
			System.out.println("Incorrect arguements");
		}

	}

	/*
	 * Class that will be used to store in the hash map implementation.
	 */

	public static class UACourse {

		public UACourse(int id, String courseName, String courseInstructor) {
			this.id = id;
			this.courseName = courseName;
			this.courseInstructor = courseInstructor;
		}

		public int id;
		public String courseName;
		public String courseInstructor;

		public String toString() {
			return String.format("Hash Code: %15d      Course Info: %30s %n", this.hashCode(),
					this.courseName + ", " + this.courseInstructor);
		}

		// Be sure to update this method!
		public int hashCode() {

			return this.id;
		}
	}

	/*
	 * Specific implementations of hash maps
	 */

	public static class UAHashTableLinearProbing extends UAHashTable {

		public UAHashTableLinearProbing(int size) {

			super(size);
		}

		public UAHashTableLinearProbing() {
			this(INITIAL_SIZE);
		}

		public void insert(UACourse k) {
			
			if(hashMapSize == T.length) {
				resize();
			}
			int i = 0;
			int hash = k.hashCode() % T.length;

			while (T[hash] != null) {

				i++;
				collisionCount++;
				hash = (k.hashCode() + i) % T.length;

			}

			T[hash] = k;
			hashMapSize++;
		}

		public UACourse search(int id) {

			int hash = id % T.length;

			for (int i = 0; i < T.length; i++) {

				hash = (id + i) % T.length;

				if (T[hash] != null && T[hash].id == id) {
					return T[hash];
				}
			}

			return null;
		}

	}

	public static class UAHashTableQuadraticProbing extends UAHashTable {

		int c1 = 3;
		int c2 = 7;

		public UAHashTableQuadraticProbing(int size) {

			super(size);
		}

		public UAHashTableQuadraticProbing() {

			this(INITIAL_SIZE);
		}

		public void insert(UACourse k) {

			if(hashMapSize == T.length) {
				resize();
			}
			int i = 0;
			int hash = k.hashCode() % T.length;

			while (T[hash] != null) {

				i++;
				collisionCount++;

				hash = (k.hashCode() + (i * c1) + (i ^ 2 * c2)) % T.length;
			}
			T[hash] = k;
			hashMapSize++;
		}

		public UACourse search(int id) {

			int hash = id % T.length;

			for (int i = 0; i < T.length; i++) {

				hash = (id + (i * c1) + (i ^ 2 * c2)) % T.length;

				if (T[hash] != null && T[hash].id == id) {
					return T[hash];
				}
			}

			return null;
		}

	}

	public static class UAHashTableDoubleHashing extends UAHashTable {

		public UAHashTableDoubleHashing(int size) {
			super(size);
		}

		public UAHashTableDoubleHashing() {
			this(INITIAL_SIZE);
		}

		public void insert(UACourse k) {

			
			if(hashMapSize == T.length) {
				resize();
			}
			int i = 0;
			int hash = k.hashCode() % T.length;
			
			
			while (T[hash] != null) {
				
				i++;
				collisionCount++;

				hash = (k.hashCode() + (i * (1 + (k.hashCode() % (T.length - 1))))) % T.length;
				
				
			}
			T[hash] = k;
			hashMapSize++;
		}

		public UACourse search(int id) {

			int hash = id % T.length;

			for (int i = 0; i < T.length; i++) {

				hash = (id + (i * (1 + (id % (T.length - 1))))) % T.length;

				if (T[hash] != null && T[hash].id == id) {
					return T[hash];
				}
			}

			return null;
		}

	}

}