package examples.dynamic.clsses.load;

public class Test {

	public static void main(String[] args) throws Exception{
		A a=(A)Class.forName("dynamic.clsses.load."+args[0]).newInstance();
		a.print();
	}

}
