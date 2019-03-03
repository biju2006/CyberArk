package visitorPackage;

public class Employee {
	private String _name;
	private int _salary;
	private String _department;
	
	public Employee(String name , int salary, String department)
	{
		_name = name;
		_salary = salary;
		_department = department;
	}
	
	public void accept(Visitor v)
	{
		v.visit(this);		
	}
	
	public int getSalary()
	{
		return _salary;
	}
	
	public String getDepartment()
	{
		return _department;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public void setSalary(int salary)
	{
		_salary = salary;
	}
}
