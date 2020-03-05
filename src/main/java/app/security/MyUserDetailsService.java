package app.security;

import app.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MerchantService service;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return service.findMerchantByEmail(email).map(MyUserDetails::new).
                orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));
    }

}
