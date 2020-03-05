package app.services;

import app.entities.Merchant;
import app.repo.MerchantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MerchantService {
    @Autowired
    private MerchantRepo repo;

    public Optional<Merchant> findMerchantByEmail(String email) {
        return repo.findMerchantByEmail(email);
    }

    public Optional<Merchant> findMerchantByMerchantId(Long merchantId) {
        return repo.findMerchantByMerchantId(merchantId);
    }

    public String register(Merchant merchant) {
        if (repo.findMerchantByEmail(merchant.getEmail()).isPresent()) return "User already exists with this mail";
        else {
            merchant.setRoles("ROLES_USER");
            merchant.setActive(true);
            repo.save(merchant);
            return "Register succeed. Please confirm your mail";
        }
    }

    public Iterable<Merchant> merchants() {
        return repo.findAll();
    }
}
