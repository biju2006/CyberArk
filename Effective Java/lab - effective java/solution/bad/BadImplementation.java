package bad;

public class BadImplementation {
	private  int index=1;
	private Person youngest;
	
	public String print(Person...people){
		String result="";
		for(Person curr:people){
			result.concat((index++)+"). ");
			result.concat(printData(curr));
			result.concat("\n");
		}
		index=1;
		return result;
	}
	
	private String printData(Person person){
		String result="";
		result+="Name: "+person.getName()+" ";
		result+="Age: "+person.getAge()+" ";
		result+="Height: "+person.getHeight()+" ";
		result+="Weight: "+person.getWeight();
		return result;
	}
	
	public String printYoungest(Person...people){
		for(Person curr:people){
			if(youngest==null){
				youngest=people[0];
			}else{
				check(curr);
			}
		}
		return youngest.getName();
	}
	
	private void check(Person curr){
		int youngestAge=youngest.getAge();
		int currAge=curr.getAge();
		if(youngestAge>currAge)
			youngest=curr;
	}
}


