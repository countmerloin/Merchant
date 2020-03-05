package app.api;

import app.entities.Merchant;
import app.services.MerchantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {

    private MerchantService service;

    @GetMapping("/all")
    public Iterable<Merchant> merchants() {
        return service.merchants();
    }
}
