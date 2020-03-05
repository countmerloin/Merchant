package app.repo;

import app.entities.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TokenRepo extends CrudRepository<Token, Long>{
    Optional<Token> findTokenByMerchantEmail(String email);
    Optional<Token> findTokenByConfirmToken(String confirm);
    Optional<Token> findTokenByPassToken(String pass);
}
