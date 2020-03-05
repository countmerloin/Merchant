package app.entities;

import app.utilities.CurrentUser;
import javax.persistence.*;

@Entity
@Table
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(nullable = false, unique = true)
    private String merchantEmail;
    @Column(nullable = false, unique = true)
    private String confirmToken;
    @Column(nullable = false, unique = true)
    private String passToken;

    public Token() {}

    public Token (String confirmToken, String passToken) {
        this.confirmToken = confirmToken;
        this.passToken = passToken;
        this.merchantEmail = CurrentUser.get().getEmail();
    }

    public String getMerchantEmail() {
        return merchantEmail;
    }

    public void setMerchantEmail(String merchantEmail) {
        this.merchantEmail = merchantEmail;
    }

    public String getConfirmToken() {
        return confirmToken;
    }

    public void setConfirmToken(String confirmToken) {
        this.confirmToken = confirmToken;
    }

    public String getPassToken() {
        return passToken;
    }

    public void setPassToken(String passToken) {
        this.passToken = passToken;
    }
}
