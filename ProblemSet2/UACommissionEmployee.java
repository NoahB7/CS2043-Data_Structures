
public class UACommissionEmployee extends UAEmployee{
	
	/********************************
	Name: Noah Buchanan
	Username: ua203
	Problem Set: PS2
	Due Date: June 15,2020
	********************************/
	
	private float commissionRate;
	private float grossSales;
	
	public float getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(float commissionRate) {
		this.commissionRate = commissionRate;
	}
	public float getGrossSales() {
		return grossSales;
	}
	public void setGrossSales(float grossSales) {
		this.grossSales = grossSales;
	}
	
	public double calcWage() {
		return grossSales * commissionRate;
	}
	
	public String toString() {
		return getFirstName() + "," + getLastName() + "," + getEmployeeId() + "," + getDepartment() + "," + calcWage();
		
	}
	
	public UACommissionEmployee() {
		super("","",0,"");
	}
	public UACommissionEmployee(String firstName, String lastName, int employeeId, String department) {
		super(firstName,lastName,employeeId,department);
	}

}
