package model.users;

import authentication.AccountInfo;

public interface User {
    long getId();
    String getName();
    AccountInfo getAccountInfo();
}
