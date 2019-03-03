import java.util.*;
import java.util.concurrent.*;


public class Factory 
{
	public static void main(String[] args) 
	{
		final Stack myStack = new Stack();
		ExecutorService executor=Executors.newCachedThreadPool();
		//ExecutorService executor=Executors.newFixedThreadPool(2);
        Callable<Integer> producer1=new Producer<Integer>("Producer1",myStack);
        Callable<Integer> producer2=new Producer<Integer>("Producer2",myStack);
        Callable<Integer> consumer1=new Consumer<Integer>("Consumer1",myStack);
        Callable<Integer> consumer2=new Consumer<Integer>("Consumer2",myStack);
        
        Collection<Callable<Integer>> col=new HashSet<Callable<Integer>>();        
        col.add(producer1);
        col.add(producer2);
        col.add(consumer1);
        col.add(consumer2);
        try {
			executor.invokeAll(col);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}
}
