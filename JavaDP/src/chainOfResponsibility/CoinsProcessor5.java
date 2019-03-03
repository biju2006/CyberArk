package chainOfResponsibility;

public class CoinsProcessor5 extends MoneyProcessor {
	
	public CoinsProcessor5(MoneyProcessor nextProcessor) {
		super(nextProcessor);
	}

	@Override
	public void processWithdrawRequest(int amount) {
		int coins=amount/5;
		if(coins>max)
			coins=max*5;
		amount-=coins*5;
		System.out.println("5 NIS coins - "+coins);
		if(amount>0&&nextProcessor!=null){
			nextProcessor.processWithdrawRequest(amount);
		}
	}

}
