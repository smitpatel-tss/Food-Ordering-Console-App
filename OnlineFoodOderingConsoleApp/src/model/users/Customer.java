package model.users;

import authentication.AccountInfo;

public class Customer implements User{
    private long id;
    private String name;
    AccountInfo accountInfo;

    public Customer(long id, String name, AccountInfo accountInfo) {
        this.id = id;
        this.name = name;
        this.accountInfo=accountInfo;
    }

    public AccountInfo getAccountInfo(){
        return accountInfo;
    }

    public long getId(){
        return id;
    }

    public String getName() {
        return name;
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
