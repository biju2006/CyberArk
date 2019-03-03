import good.GoodImplementation;
import bad.BadImplementation;
import bad.Person;


public class Test {

	public static void testBad(){
		Person[]people=new Person[20];
		people[0]=new Person("AAA",45,65.5F,1.56F);
		people[1]=new Person("BBB",10,25.0F,1.05F);
		people[2]=new Person("CCC",67,75.5F,1.70F);
		people[3]=new Person("DDD",70,65.5F,1.89F);
		people[4]=new Person("EEE",30,57.0F,2.05F);
		people[5]=new Person("FFF",41,55.5F,1.73F);
		people[6]=new Person("GGG",12,29.0F,1.40F);
		people[7]=new Person("HHH",84,60.0F,1.55F);
		people[8]=new Person("III",38,54.5F,1.69F);
		people[9]=new Person("JJJ",82,50.0F,1.60F);
		people[10]=new Person("KKK",16,15.0F,1.90F);
		people[11]=new Person("LLL",27,76.0F,1.65F);
		people[12]=new Person("NNN",38,45.5F,1.79F);
		people[13]=new Person("MMM",62,44.5F,1.82F);
		people[14]=new Person("OOO",88,57.0F,1.30F);
		people[15]=new Person("PPP",42,98.0F,1.88F);
		people[16]=new Person("QQQ",26,67.5F,2.13F);
		people[17]=new Person("RRR",82,50.5F,1.57F);
		people[18]=new Person("SSS",35,88.5F,1.93F);
		people[19]=new Person("TTT",11,20.0F,1.49F);

		BadImplementation bi=new BadImplementation();
		
		long start=System.currentTimeMillis();
		
		//starting !
		for(int i=0;i<100;i++){
			bi.print(people);
			bi.printYoungest(people);
		}
		//ending !
		
		long end=System.currentTimeMillis();
		System.out.println("Total Execution Time : "+(end-start)+" ms");
		
	}
	
	public static void testGood(){
		good.Person[]people=new good.Person[20];
		people[0]=new good.Person("AAA",45,65.5F,1.56F);
		people[1]=new good.Person("BBB",10,25.0F,1.05F);
		people[2]=new good.Person("CCC",67,75.5F,1.70F);
		people[3]=new good.Person("DDD",70,65.5F,1.89F);
		people[4]=new good.Person("EEE",30,57.0F,2.05F);
		people[5]=new good.Person("FFF",41,55.5F,1.73F);
		people[6]=new good.Person("GGG",12,29.0F,1.40F);
		people[7]=new good.Person("HHH",84,60.0F,1.55F);
		people[8]=new good.Person("III",38,54.5F,1.69F);
		people[9]=new good.Person("JJJ",82,50.0F,1.60F);
		people[10]=new good.Person("KKK",16,15.0F,1.90F);
		people[11]=new good.Person("LLL",27,76.0F,1.65F);
		people[12]=new good.Person("NNN",38,45.5F,1.79F);
		people[13]=new good.Person("MMM",62,44.5F,1.82F);
		people[14]=new good.Person("OOO",88,57.0F,1.30F);
		people[15]=new good.Person("PPP",42,98.0F,1.88F);
		people[16]=new good.Person("QQQ",26,67.5F,2.13F);
		people[17]=new good.Person("RRR",82,50.5F,1.57F);
		people[18]=new good.Person("SSS",35,88.5F,1.93F);
		people[19]=new good.Person("TTT",11,20.0F,1.49F);

		GoodImplementation gi=new GoodImplementation();
		
		long start=System.currentTimeMillis();
		
		//starting !
		for(int i=0;i<100;i++){
			gi.print(people);
			gi.printYoungest(people);
		}
		//ending !
		
		long end=System.currentTimeMillis();
		System.out.println("Total Execution Time : "+(end-start)+" ms");
		
	}
	public static void main(String[] args) {
		testBad();
		testGood();
	}

}
