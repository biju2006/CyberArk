package java9.flow;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;

public class Test {

	public static void main(String[] args) {
		runSimpleMessaging();
		System.out.println("_____");
		runProcessedMessaging();
	}
		
		public static void runSimpleMessaging() {
		//Create Publisher  
	    SubmissionPublisher<String> publisher = new SubmissionPublisher<>();    
	    
	    //Register Subscriber  
	    MySubscriber<String> subscriber = new MySubscriber<>();  
	    publisher.subscribe(subscriber);
	  
	    //Publish items  
	    System.out.println("Publishing Items...");  
	    String[] items = {"1", "x", "2", "x", "3", "x"};  
	    Arrays.asList(items).stream().forEach(publisher::submit);  
	    publisher.close(); 
	      
	    try{Thread.sleep(1000);}catch(Exception e) {}
	}
	
	
	public static void runProcessedMessaging() {
		//Create Publisher  
	    SubmissionPublisher<String> publisher = new SubmissionPublisher<>();   
	    
	    //Creating Endpoint Subscriber  
	    MySubscriber<Integer> subscriber = new MySubscriber<>();  

	    //Creating Midpoints Processors
	    MyTransformProcessor<String, String> transformProcessor = new MyTransformProcessor<>(s -> {if(s.equals("x"))return "0"; return s;}); 
	    MyConvertProcessor<String, Integer> convertProcessor = new MyConvertProcessor<>(s -> Integer.parseInt(s)); 
	    
	    //Configuring subscription chain
	    publisher.subscribe(transformProcessor);
	    transformProcessor.subscribe(convertProcessor);
	    convertProcessor.subscribe(subscriber);
	    
	    //Publish items  
	    System.out.println("Publishing Items...");  
	    String[] items = {"1", "x", "2", "x", "3", "x"};  
	    Arrays.asList(items).stream().forEach(publisher::submit);  
	    publisher.close(); 
	    
	    
	    try{Thread.sleep(10000);}catch(Exception e) {}
	}

}
