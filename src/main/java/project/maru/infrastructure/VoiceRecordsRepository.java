package project.maru.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import project.maru.domain.VoiceRecords;

public interface VoiceRecordsRepository extends JpaRepository<VoiceRecords, Long> {

}
