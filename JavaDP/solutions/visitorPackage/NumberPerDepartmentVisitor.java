package visitorPackage;

public class NumberPerDepartmentVisitor implements Visitor
{
	private String _department;
	private int _numberPerDept;
	
	public NumberPerDepartmentVisitor()
	{
		_department = "";
		_numberPerDept = 0;
	}
	
	public void visit(Employee emp)
	{
		if(emp.getDepartment().equals(_department))
			_numberPerDept++;
	}
	
	public void setDepartment(String dept)
	{
		_department = dept;
	}
	
	public void print()
	{
		System.out.println("The number per department " + _department + " is " + _numberPerDept);
	}
}
