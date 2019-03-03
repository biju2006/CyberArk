package visitorPackage;

public class TotalSalaryVisitor implements Visitor
{
	private int _totalSalary;
	
	public TotalSalaryVisitor()
	{
		_totalSalary = 0;
	}
	
	public void visit(Employee emp)
	{
		_totalSalary += emp.getSalary();
	}
	
	public void print()
	{
		System.out.println("The total salary is " + _totalSalary);
	}
}
