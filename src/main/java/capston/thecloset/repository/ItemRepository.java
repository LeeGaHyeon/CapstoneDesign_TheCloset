package capston.thecloset.repository;

import capston.thecloset.domain.Category;
import capston.thecloset.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ItemRepository extends JpaRepository<Item,Long> {

    @Modifying @Transactional
    @Query("SELECT i from Item i join fetch i.member m where m.userId = :userId AND i.category = :category")
    public List<Item> findItemByCategoryAndUserId(@Param("userId") String userId, @Param("category") String category);

    @Modifying @Transactional
    @Query("SELECT i from Item i join fetch i.member m where m.userId = :userId")
    public List<Item> findItemByUserId(@Param("userId") String userId);


}
