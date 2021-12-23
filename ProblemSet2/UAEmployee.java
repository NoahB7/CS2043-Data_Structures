
public class UAEmployee {
	
	/********************************
	Name: Noah Buchanan
	Username: ua203
	Problem Set: PS2
	Due Date: June 15,2020
	********************************/
	
	private String firstName;
	private String lastName;
	private int employeeId;
	private String department;
	
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
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public double calcWage() {
		return 0;
	}
	
	public String toString() {
		return getFirstName() + "," + getLastName() + "," + getEmployeeId() + "," + getDepartment() + "," + calcWage();
		
	}
	
	public UAEmployee(String firstName, String lastName, int employeeId, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.department = department;
	}
	
	
}
