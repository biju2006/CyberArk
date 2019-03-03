package BuilderEx;

import java.util.Date;

public abstract class AccountBuilder {

    protected Account account; // protected so only classes extends Account Builder will be able to access

    public void setCurrentId(long currentId) {
        account.setId(currentId);
    }

    public Account getAccount() {
        return account;
    }

    public void createNewAccount() {
        account = new Account();
    }

    public abstract void setType();

    public abstract void setCommision();

    public void setStartDate(Date date) {
        account.setStartDate(date);
    }

    public void setEndDate(Date date) {
        account.setEndDate(date);
    }


}
