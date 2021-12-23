
public class UASalaryEmployee extends UAEmployee{
	
	/********************************
	Name: Noah Buchanan
	Username: ua203
	Problem Set: PS2
	Due Date: June 15,2020
	********************************/
	
	private double monthlySalary;

	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	public double calcWage() {
		return monthlySalary;
	}
	
	public String toString() {
		return getFirstName() + "," + getLastName() + "," + getEmployeeId() + "," + getDepartment() + "," + calcWage();
		
	}
	
	public UASalaryEmployee() {
		super("","",0,"");
	}
	
	public UASalaryEmployee(String firstName, String lastName, int employeeId, String department) {
		super(firstName,lastName,employeeId,department);
	}
	public UASalaryEmployee(String x) {
		
		super("","",0,"");
		String[] y = x.split(",");
		setFirstName(y[0]);
		setLastName(y[1]);
		setEmployeeId(Integer.parseInt(y[2]));
		setDepartment(y[3]);
		setMonthlySalary(Integer.parseInt(y[4]));
	}

}
