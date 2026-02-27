package model.users;

import authentication.AccountInfo;

public class DeliveryPartner implements User{
    private long id;
    private String name;
    private AccountInfo accountInfo;

    public DeliveryPartner(long id, String name, AccountInfo accountInfo) {
        this.id = id;
        this.name = name;
        this.accountInfo=accountInfo;
    }

    public long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public AccountInfo getAccountInfo(){
        return accountInfo;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | Name: %s | Phone: %s",
                id,
                name,
                accountInfo.getPhoneNumber()
        );
    }
}
