package chainOfResponsibility;

public abstract class MoneyProcessor {

	//allow one processor to get instantiated with the next processor
	//might be null - if it is the last processor in the chain...
	protected MoneyProcessor nextProcessor;
	
	public MoneyProcessor(MoneyProcessor nextProcessor){
		this.nextProcessor=nextProcessor;
	}
	
	//max number of bills or coins the processor can give in each transaction
	//default in the cash machine - 10 
	protected int max=10;  
	
	public abstract void processWithdrawRequest(int amount);
}
