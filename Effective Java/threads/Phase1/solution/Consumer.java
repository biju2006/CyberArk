public class Consumer implements Runnable 
{
	String consumerId;
	Stack s;

	public Consumer(String consumerId, Stack s){
		this.consumerId = consumerId;
		this.s = s;
	}

	public void run(){
		for(int i = 0; i <20; i++){
			long sleepTime=(long)(Math.random()*1500+500);
			try {
				Thread.sleep(sleepTime);
		}catch(Exception ex){ex.printStackTrace();}

			s.pop();			
		}
	}
}
