package app.services;

import app.entities.Product;
import app.repo.ProductRepo;
import app.utilities.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public Iterable<Product> findMerchantProducts(Long merchantId) {
        return repo.findProductsByMerchantId(merchantId);
    }

    public void addProduct(Product product) {
        product.setMerchantId(CurrentUser.get().getMerchantId());
        repo.save(product);
    }

}
