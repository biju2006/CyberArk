package visitorPackage;

public class AverageSalaryVisitor implements Visitor
{
	private int _totalSalary;
	private int _numberOfEmployees;
	
	public AverageSalaryVisitor()
	{
		_totalSalary = 0;
	}
	
	public void visit(Employee emp)
	{
		_numberOfEmployees++;
		_totalSalary += emp.getSalary();				
	}
	
	public void print()
	{
		System.out.println("The average salary is " + _totalSalary/this._numberOfEmployees);
	}
}
