package chainOfResponsibility;

public class BillsProcessor200 extends MoneyProcessor {
	
	public BillsProcessor200(MoneyProcessor nextProcessor) {
		super(nextProcessor);
	}

	@Override
	public void processWithdrawRequest(int amount) {
		int bills=amount/200;
		if(bills>max)
			bills=max;
		amount-=bills*200;
		System.out.println("200 NIS bills - "+bills);
		if(amount>0&&nextProcessor!=null){
			nextProcessor.processWithdrawRequest(amount);
		}
	}

}
