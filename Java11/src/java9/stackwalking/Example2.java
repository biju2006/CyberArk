package java9.stackwalking;

import java.lang.StackWalker.StackFrame;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {

	public void pathA() {
		a();
	}
	
	public void pathB() {
		b();
	}  
	
	public void a() {
		b();
	}
	
	public void b() {
		c();
	}
	
	public void c() {
		StackWalker sw=StackWalker.getInstance();
		long size=sw.walk(elements->elements.count());
		System.out.println("Total frames: "+size);
		List<StackFrame> frames=sw.walk(elements->elements.collect(Collectors.toList()));
		
		if(frames.stream().filter(s->s.getMethodName().equals("a")).count()==0) {
			System.out.println("You skipped a()..");
		}else {
			System.out.println("You went all the way!");
		}
	}
	
}
