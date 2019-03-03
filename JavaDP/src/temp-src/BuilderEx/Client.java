package BuilderEx;

public class Client {

    public static void main(String[] args) {
        AccountDirector accountDirector = new AccountDirector();
        RegularAccountBuilder regularAccountBuilder = new RegularAccountBuilder();
        accountDirector.setAccountBuilder(regularAccountBuilder);
        accountDirector.constructAccount();
        Account account = accountDirector.getAccount();
        System.out.println(account.getType());
    }

}
