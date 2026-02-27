package model.users;

import authentication.AccountInfo;

public class Admin implements User{
    private long id;
    private String name;
    private AccountInfo accountInfo;

    public Admin(long id, String name, AccountInfo accountInfo) {
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
}
