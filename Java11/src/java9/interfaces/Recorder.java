package java9.interfaces;

import java.text.DateFormat;
import java.util.Date;

public interface Recorder<T> {
   
	default void startRecord() {
		System.out.println("recording started at: ");//+timestamp());
	}
	
	void record(T data);
	
	default void endRecord() {
		System.out.println("recording stopped at: ");//+timestamp());
	}
	
	private String timestamp() {
		Date now=new Date();
		return DateFormat.getTimeInstance().format(now);
	}
}
