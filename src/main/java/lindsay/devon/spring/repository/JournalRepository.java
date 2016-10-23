package lindsay.devon.spring.repository;

import lindsay.devon.spring.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by devon on 10/20/16.
 */
public interface JournalRepository extends JpaRepository <Journal,Long>{
}
