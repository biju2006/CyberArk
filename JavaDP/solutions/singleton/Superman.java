package singleton;

public class Superman {
	
	private static Superman superman=new Superman();
	
	public static Superman callSuperman(){
		return superman;
	}
	
	private Superman(){}
	
	public void liftBuildings(){
		System.out.println("I'm lifting a building");
	}
	
	public void stopBullets(){
		System.out.println("I'm stopping bullets");
	}
	
	public void reverseTime(){
		System.out.println("I'm reversing time");
	}
	
	public void fly(){
		System.out.println("I'm flying");
	}
}
