package adapter;

public class ObjectStackAdapter implements Stack {

	StackAdaptee stack=new StackAdaptee();
	
	public void add(char ch) {
		stack.addElement(ch);
	}
	
	public void printStack(){
		stack.print();
	}

}
