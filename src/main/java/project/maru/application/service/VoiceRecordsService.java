package project.maru.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.maru.application.dto.voiceRecordsDto.VoiceRecordsCreateRequest;
import project.maru.domain.VoiceRecords;
import project.maru.instructure.VoiceRecordsRepository;

@Service
@RequiredArgsConstructor
public class VoiceRecordsService {

  private final VoiceRecordsRepository voiceRecordsRepository;

  @Transactional
  public VoiceRecords postVoiceRecords(
      VoiceRecordsCreateRequest vr) {
    VoiceRecords vRecords = new VoiceRecords(vr.getUserId(), vr.getQuestionsKrId(),
        vr.getSpeechToText(), vr.getMatchingRate());
    return voiceRecordsRepository.save(vRecords);
  }
}
