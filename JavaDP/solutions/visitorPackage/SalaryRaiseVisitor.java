package visitorPackage;

public class SalaryRaiseVisitor implements Visitor 
{
	private int _raise;
	
	public SalaryRaiseVisitor()
	{
		_raise = 100;
	}
	
	public void setRaise(int raise)
	{
		_raise = raise;
	}
	
	public void visit(Employee emp)
	{
		emp.setSalary(emp.getSalary()*(_raise+100)/100);
	}
	
	public void print()
	{
		System.out.println("The salary was raised by " + _raise + " percent");
	}

}
