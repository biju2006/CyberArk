import java.util.concurrent.Callable;

public class Producer<T> implements Callable<Integer> 
{
	String producerId;
	Stack s;

	public Producer(String producerId, Stack s){
		this.producerId = producerId;
		this.s = s;
	}

	public Integer call() throws Exception {
		for(int i = 0; i <20; i++){
			try {
				Thread.sleep((long)Math.random()*1500+500);
			}catch(Exception ex){ex.printStackTrace(); return 1;}
			s.push(i);
		}
		return 0;
	}
}
