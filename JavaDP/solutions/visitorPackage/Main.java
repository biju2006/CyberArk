//solution checked

package visitorPackage;

import java.util.Vector;

public class Main {
	
	public static void main(String [] args)
	{
		Vector v = new Vector();
		v.add(new Employee("Eytan",100000, "Training"));
		v.add(new Employee("Hava", 20000, "Finance"));
		v.add(new Employee("Ronen",50000,"Training"));
		
		Company c = new Company(v);
		
		c.activity(new TotalSalaryVisitor());
		c.activity(new NumberOfEmployeesVisitor());
		c.activity(new AverageSalaryVisitor());
		
		SalaryRaiseVisitor srv = new SalaryRaiseVisitor();
		srv.setRaise(15);
		c.activity(srv);
		//after the raise
		c.activity(new TotalSalaryVisitor());
		c.activity(new AverageSalaryVisitor());
		
		NumberPerDepartmentVisitor npd = new NumberPerDepartmentVisitor();
		npd.setDepartment("Finance");
		c.activity(npd);
		
		
	}
}
