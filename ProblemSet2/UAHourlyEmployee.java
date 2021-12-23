
public class UAHourlyEmployee extends UAEmployee{
	
	/********************************
	Name: Noah Buchanan
	Username: ua203
	Problem Set: PS2
	Due Date: June 15,2020
	********************************/
	
	private float wage;
	private int numHoursWorked;
	
	public float getWage() {
		return wage;
	}
	public void setWage(float wage) {
		this.wage = wage;
	}
	public int getNumHoursWorked() {
		return numHoursWorked;
	}
	public void setNumHoursWorked(int numHoursWorked) {
		this.numHoursWorked = numHoursWorked;
	}
	
	public double calcWage() {
		return wage * numHoursWorked;
	}
	
	public String toString() {
		return getFirstName() + "," + getLastName() + "," + getEmployeeId() + "," + getDepartment() + "," + calcWage();
		
	}
	
	public UAHourlyEmployee() {
		super("","",0,"");
	}
	
	public UAHourlyEmployee(String firstName, String lastName, int employeeId, String department) {
		super(firstName,lastName,employeeId,department);
	}
	
	

}
