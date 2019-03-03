import java.util.concurrent.Callable;

public class Consumer<T> implements Callable<Integer> 
{
	String consumerId;
	Stack s;

	public Consumer(String consumerId, Stack s){
		this.consumerId = consumerId;
		this.s = s;
	}

	public Integer call() throws Exception {
		for(int i = 0; i <20; i++){
			long sleepTime=(long)(Math.random()*1500+500);
			try {
				Thread.sleep(sleepTime);
		}catch(Exception ex){ex.printStackTrace(); return 1;}

			s.pop();			
		}
		return 0;
	}
}
