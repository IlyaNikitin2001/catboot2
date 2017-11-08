package catboot2.repository;

import catboot2.domain.Cat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by USER on 06.11.2017.
 */
public interface CatRepository extends CrudRepository<Cat,Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE cat SET " +
            "name = COALESCE(?2, name), " +
            "poroda = COALESCE(?3, poroda) " +
            "WHERE id = ?1", nativeQuery = true)
    void updateCat(Integer Id,  String name, String poroda);
}
