package BuilderEx;

public class AccountDirector {

    private AccountBuilder accountBuilder;

    public void setAccountBuilder(AccountBuilder accountBuilder) {
        this.accountBuilder = accountBuilder;
    }

    public void constructAccount() {

        accountBuilder.createNewAccount();
        accountBuilder.setType();
        accountBuilder.setCommision();
    }

    public Account getAccount() {
        return accountBuilder.getAccount();
    }

}
