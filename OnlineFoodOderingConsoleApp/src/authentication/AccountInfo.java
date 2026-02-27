package authentication;

public class AccountInfo {
    private String phoneNumber;
    private String password;

    public AccountInfo(String phoneNumber,String password){
        this.phoneNumber=phoneNumber;
        this.password=password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
