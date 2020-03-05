package app.utilities;

import app.entities.Merchant;
import app.repo.MerchantRepo;
import app.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentUser {

    private static MerchantRepo repo;

    @Autowired
    public CurrentUser(MerchantRepo repo) {
        CurrentUser.repo = repo;
    }

    public static Merchant get() {
        MyUserDetails details = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repo.findMerchantByEmail(details.getUsername()).get();
    }
}
