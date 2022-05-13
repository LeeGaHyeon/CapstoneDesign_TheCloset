package capston.thecloset.repository;

import capston.thecloset.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item,Long> {
}
