package project.maru.instructure;

import org.springframework.data.jpa.repository.JpaRepository;
import project.maru.domain.VoiceRecords;

public interface VoiceRecordsRepository extends JpaRepository<VoiceRecords, Long> {

}
