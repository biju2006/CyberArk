package chainOfResponsibility;

public class BillsProcessor20 extends MoneyProcessor {
	
	public BillsProcessor20(MoneyProcessor nextProcessor) {
		super(nextProcessor);
	}

	@Override
	public void processWithdrawRequest(int amount) {
		int bills=amount/20;
		if(bills>max)
			bills=max;
		amount-=bills*20;
		System.out.println("20 NIS bills - "+bills);
		if(amount>0&&nextProcessor!=null){
			nextProcessor.processWithdrawRequest(amount);
		}
	}

}
