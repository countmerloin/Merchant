package app.services;

import app.security.MyUserDetails;
import app.security.jwt.JwtManager;
import app.utilities.JwtConstants;
import app.utilities.LoginRq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private MerchantService ms;
    @Autowired
    private JwtManager jwt;
    @Autowired
    private AuthenticationManager manager;


    public Optional<String> login (String email, String psw,boolean remember) {
      return Optional.of(manager.authenticate(new UsernamePasswordAuthenticationToken(email, psw)))
                    .filter(Authentication::isAuthenticated)
                    .map(a -> {
                        SecurityContextHolder.getContext().setAuthentication(a); return a; })
                    .map(a -> (MyUserDetails) a.getPrincipal())
                    .map(ud-> jwt.generateToken(ud.getUsername(), remember))
                    .map(t-> JwtConstants.bearer + t);

    }
}
