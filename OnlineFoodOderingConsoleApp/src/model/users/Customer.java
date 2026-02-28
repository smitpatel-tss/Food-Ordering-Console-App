package model.users;

import authentication.AccountInfo;

public class Customer implements User{
    private long id;
    private String name;
    private AccountInfo accountInfo;
    private String address;

    public Customer(long id, String name, AccountInfo accountInfo) {
        this.id = id;
        this.name = name;
        this.accountInfo=accountInfo;
    }

    public AccountInfo getAccountInfo(){
        return accountInfo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
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
