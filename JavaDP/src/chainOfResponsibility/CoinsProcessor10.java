package chainOfResponsibility;

public class CoinsProcessor10 extends MoneyProcessor {
	
	public CoinsProcessor10(MoneyProcessor nextProcessor) {
		super(nextProcessor);
	}

	@Override
	public void processWithdrawRequest(int amount) {
		int coins=amount/10;
		if(coins>max)
			coins=max*10;
		amount-=coins*10;
		System.out.println("10 NIS coins - "+coins);
		if(amount>0&&nextProcessor!=null){
			nextProcessor.processWithdrawRequest(amount);
		}
	}

}
