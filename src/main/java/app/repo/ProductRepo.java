package app.repo;

import app.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
    Iterable<Product> findProductsByMerchantId(Long merchantId);

    @Override
    <S extends Product> S save(S s);
}
