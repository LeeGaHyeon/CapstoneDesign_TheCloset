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

    //사용자 카테고리별 리스트
    @Query("SELECT i from Item i join fetch i.member m where m.userId = :userId AND i.category = :category")
    public List<Item> findItemByCategoryAndUserId(@Param("userId") String userId, @Param("category") Category category);

    //사용자 전체 리스트
    @Query("SELECT i from Item i join fetch i.member m where m.userId = :userId")
    public List<Item> findItemByUserId(@Param("userId") String userId);


}
