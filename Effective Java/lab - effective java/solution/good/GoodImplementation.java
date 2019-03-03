package good;

public class GoodImplementation {
	
	public String print(Person...people){
		int index=1;
		StringBuffer result=new StringBuffer(300);
		for(Person curr:people){
			result.append((index++)+curr.toString());
		}
		return result.toString();
	}
	
	public String printYoungest(Person...people){
		Person youngest=people[0];
		for(Person curr:people){
			if(youngest.getAge()>curr.getAge())
				youngest=curr;
		}
		return youngest.toString();
	}
}


