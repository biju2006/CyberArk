package BuilderEx;

public class RegularAccountBuilder extends AccountBuilder {


    @Override
    public void setType() {
        account.setType(AccountType.REGULAR);
    }

    @Override
    public void setCommision() {
        account.setCommision(Commisions.REGULAR_COMMISION);
    }
}
