package java9.stackwalking;

public class Example1 {
	
	public void a() {
		b();
	}
	
	public void b() {
		c();
	}
	
	public void c() {
		StackWalker sw=StackWalker.getInstance();
		sw.forEach(System.out::println);
	}
	
}
