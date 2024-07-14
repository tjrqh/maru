package project.maru.infrastructure;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.maru.domain.Quotes;

public interface QuotesRepository extends JpaRepository<Quotes, Long> {

  @Query("SELECT q.id FROM Quotes q WHERE q.contentType.id = :contentTypeId")
  List<Integer> findByContentTypeId(int contentTypeId);

}
