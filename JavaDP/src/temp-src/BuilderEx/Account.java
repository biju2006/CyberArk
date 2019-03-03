package BuilderEx;

import java.util.Date;

public class Account {
    private long id;
    private AccountType type;
    private Date startDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Commisions getCommision() {
        return commision;
    }

    public void setCommision(Commisions commision) {
        this.commision = commision;
    }

    private Date endDate;
    private double balance;
    private Commisions commision;



}
