package java9.interfaces;

public class Test {

	public static void main(String[] args) { 
		RecorderImpl r=new RecorderImpl();
		r.startRecord();
		r.record("Hello World!");
		r.endRecord();  
	}

}
