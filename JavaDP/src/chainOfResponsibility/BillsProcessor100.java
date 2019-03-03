package chainOfResponsibility;

public class BillsProcessor100 extends MoneyProcessor {
	
	public BillsProcessor100(MoneyProcessor nextProcessor) {
		super(nextProcessor);
	}

	@Override
	public void processWithdrawRequest(int amount) {
		int bills=amount/100;
		if(bills>max)
			bills=max;
		amount-=bills*100;
		System.out.println("100 NIS bills - "+bills);
		if(amount>0&&nextProcessor!=null){
			nextProcessor.processWithdrawRequest(amount);
		}
	}

}
