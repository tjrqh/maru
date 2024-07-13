package project.maru.instructure;

import org.assertj.core.internal.Longs;
import org.springframework.data.jpa.repository.JpaRepository;
import project.maru.domain.Rank;


public interface UsersRepository extends JpaRepository<Rank, Longs> {

}
