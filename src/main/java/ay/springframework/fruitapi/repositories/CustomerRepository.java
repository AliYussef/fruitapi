package ay.springframework.fruitapi.repositories;

import ay.springframework.fruitapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aliyussef on 21/03/2021
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
