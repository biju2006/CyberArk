public class Producer implements Runnable 
{
	String producerId;
	Stack s;

	public Producer(String producerId, Stack s){
		this.producerId = producerId;
		this.s = s;
	}

	public void run(){
		for(int i = 0; i <20; i++){
			try {
				Thread.sleep((long)Math.random()*1500+500);
			}catch(Exception ex){ex.printStackTrace();}
			s.push(i);
		}
	}
}
