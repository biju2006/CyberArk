package chainOfResponsibility;

public class CashMachine {
	
	private MoneyProcessor startOfChain;
	
	public CashMachine(){
		startOfChain=new BillsProcessor200(
					 new BillsProcessor100(
					 new BillsProcessor50(
					 new BillsProcessor20(
					 new CoinsProcessor10(
					 new CoinsProcessor5(
					 new CoinsProcessor1(null)))))));
	}
	
	public void withdraw(int amount){
		if(amount>0){
			startOfChain.processWithdrawRequest(amount);
		}
	}
	

	public static void main(String[] args) {
		CashMachine machine=new CashMachine();
		machine.withdraw(3492);

	}

}
