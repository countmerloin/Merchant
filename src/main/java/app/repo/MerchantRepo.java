package app.repo;

import app.entities.Merchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MerchantRepo  extends CrudRepository<Merchant, Long> {

    Optional<Merchant> findMerchantByEmail(String email);
    Optional<Merchant> findMerchantByMerchantId(Long merchantId);

    @Override
    Iterable<Merchant> findAll();

    @Override
    <S extends Merchant> S save(S s);




}
