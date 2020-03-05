package app.services;

import app.entities.Merchant;
import app.entities.Token;
import app.repo.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenService {
    @Autowired
    private TokenRepo repo;
    @Autowired
    private MerchantService service;


    public String confirmAccount(String confirm) {
        Optional<Token> token = repo.findTokenByConfirmToken(confirm);
       if (token.isPresent()){
           String mail = token.get().getMerchantEmail();
           Optional<Merchant> merchant = service.findMerchantByEmail(mail);
           //implement later
           return "User activated";
       }
       return "Something went wrong";
    }
}
