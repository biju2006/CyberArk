package visitorPackage;

public class NumberOfEmployeesVisitor implements Visitor 
{
	private int _numberOfEmployees;

	public NumberOfEmployeesVisitor()
	{
		_numberOfEmployees = 0;
	}
	
	public void visit(Employee emp)
	{
		_numberOfEmployees++;
	}

	public void print()
	{
		System.out.println("The number of Employees is " + _numberOfEmployees);
	}
}
