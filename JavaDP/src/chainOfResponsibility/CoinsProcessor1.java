package chainOfResponsibility;

public class CoinsProcessor1 extends MoneyProcessor {
	
	public CoinsProcessor1(MoneyProcessor nextProcessor) {
		super(nextProcessor);
	}

	@Override
	public void processWithdrawRequest(int amount) {
		int coins=amount/1;
		if(coins>max)
			coins=max;
		amount-=coins*1;
		System.out.println("1 NIS coins - "+coins);
		if(amount>0&&nextProcessor!=null){
			nextProcessor.processWithdrawRequest(amount);
		}
	}

}
