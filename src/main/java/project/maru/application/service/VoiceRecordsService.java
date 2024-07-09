package project.maru.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.maru.application.dto.VoiceRecordsDto.VoiceRecordsCreateRequest;
import project.maru.domain.VoiceRecords;
import project.maru.instructure.VoiceRecordsRepository;

@Service
public class VoiceRecordsService {

  @Autowired
  private VoiceRecordsRepository voiceRecordsRepository;

  public VoiceRecords postVoiceRecords(
      VoiceRecordsCreateRequest vr) {
    VoiceRecords vrecords = new VoiceRecords(vr.getUserId(), vr.getQuestionsKrId(),
        vr.getSpeechToText(), vr.getMatchingRate());
    return voiceRecordsRepository.save(vrecords);
  }
}
