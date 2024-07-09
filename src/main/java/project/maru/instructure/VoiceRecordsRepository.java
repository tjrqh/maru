package project.maru.instructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.maru.domain.VoiceRecords;

@Repository
public interface VoiceRecordsRepository extends JpaRepository<VoiceRecords, Long> {


}
