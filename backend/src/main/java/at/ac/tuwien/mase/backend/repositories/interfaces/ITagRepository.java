package at.ac.tuwien.mase.backend.repositories.interfaces;

import at.ac.tuwien.mase.backend.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by xvinci on 11/14/15.
 */
public interface ITagRepository extends JpaRepository<Tag, Long> {
    @Query("SELECT t FROM Tag t WHERE t.name LIKE :name")
    Tag findByName(@Param("name") String name);

    @Query("SELECT t FROM Tag t WHERE t.name LIKE %:name% ORDER BY t.count DESC")
    List<Tag> autocompleteTag(@Param("name") String name);
}
