public class Factory 
{
	public static void main(String[] args) 
	{
		Stack myStack = new Stack();
		
		Producer producer=new Producer("Producer",myStack);
		Consumer consumer=new Consumer("Consumer",myStack);
		
		Thread [] threads=new Thread[4];
		for(int i=0;i<2;i++){
			threads[i]=new Thread(consumer);
			threads[i+2]=new Thread(producer);
		}
		for(Thread t:threads){
			t.start();
		}
	}
}
