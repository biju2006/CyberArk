package singleton;

public class Main {

	public static void main(String[] args) {

		Superman superman=Superman.callSuperman();
		superman.fly();
		Superman kalel = Superman.callSuperman();
		kalel.reverseTime();
		Superman clark = Superman.callSuperman();
		clark.liftBuildings();
		System.out.println("Are clark, superman and kalel the same person? " + 
							((clark==kalel) && (kalel==superman) && (superman==clark)));
	}

}
