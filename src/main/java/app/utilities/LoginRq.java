package app.utilities;


public class LoginRq {
    private String email;
    private String password;
    private boolean remember;

    public LoginRq(String email, String password, boolean remember) {
        this.email = email;
        this.password = password;
        this.remember = remember;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isRemember() {
        return remember;
    }
}
