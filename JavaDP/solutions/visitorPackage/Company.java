package visitorPackage;

import java.util.*;

public class Company {
	
	private Collection _c;
	
	public Company(Collection c)
	{
		_c = c;
	}
	
	public void activity(Visitor v)
	{
		Iterator i = _c.iterator();
		while(i.hasNext())
		{
			Employee e = (Employee)i.next();
			e.accept(v);
		}	
		v.print();
	}	
}
