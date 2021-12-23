
public class UABaseWithCommissionEmployee extends UACommissionEmployee{
	
	/********************************
	Name: Noah Buchanan
	Username: ua203
	Problem Set: PS2
	Due Date: June 15,2020
	********************************/
	
	private double baseSalary;
	
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public double calcWage() {
		return baseSalary + (getCommissionRate() + getGrossSales());
	}
	
	public String toString() {
		return getFirstName() + "," + getLastName() + "," + getEmployeeId() + "," + getDepartment() + "," + calcWage();
		
	}
	
	public UABaseWithCommissionEmployee() {
		
	}
	public UABaseWithCommissionEmployee(String firstName, String lastName, int employeeId, String department) {
		super(firstName,lastName,employeeId,department);
	}
	

}
