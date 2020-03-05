package app.api;

import app.entities.Merchant;
import app.services.AuthService;
import app.services.MerchantService;
import app.utilities.LoginRq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController {

    private MerchantService ms;
    private AuthService as;

    public AuthController(MerchantService ms, AuthService as) {
        this.ms = ms;
        this.as = as;
    }

    @PostMapping("/register")
    public String register(@RequestBody Merchant merchant) {
       return ms.register(merchant);
    }

    @PostMapping("/signin")
    public Optional<String> login(String email, String psw, boolean remember) {

        return as.login(email, psw, remember);
    }
}
