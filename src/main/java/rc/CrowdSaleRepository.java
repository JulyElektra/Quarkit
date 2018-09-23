package rc;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CrowdSaleRepository extends MongoRepository<CrowdSale, String> {
    Optional<CrowdSale> findById(String id);
}
