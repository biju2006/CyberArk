package java9.stackwalking;

public class Test {

	public static void main(String[] args) {
		System.out.println("Show strack trace:");
		Example1 e1=new Example1();
		e1.a();
		
		System.out.println("\nShow strack trace length, take full way:");
		Example2 e2=new Example2();
		e2.pathA();
		System.out.println("\nShow strack trace length, take shortcut:");
		e2.pathB();
		
	}

}
