package project.maru.application.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.maru.application.dto.rankDto.RankUpdateRequest;
import project.maru.application.dto.voiceRecordsDto.VoiceRecordsCreateRequest;
import project.maru.domain.QuestionsKr;
import project.maru.domain.VoiceRecords;
import project.maru.infrastructure.QuestionsKrRepository;
import project.maru.infrastructure.VoiceRecordsRepository;

@Service
@RequiredArgsConstructor
public class VoiceRecordsService {

  private final VoiceRecordsRepository voiceRecordsRepository;
  private final QuestionsKrRepository questionsKrRepository;

  public VoiceRecords voiceRecordsLinkCreate(String sub, RankUpdateRequest rankUpdateRequest){
    QuestionsKr questionsKr = questionsKrRepository.findById(rankUpdateRequest.getQuestionKrId());

        String voice = rankUpdateRequest.getVoiceRecords();
        if (voice != null && !voice.isEmpty()) {

          VoiceRecords voiceRecords = new VoiceRecords(sub, questionsKr, voice, null, 0);

          return voiceRecordsRepository.save(voiceRecords);
        }
        else {
          return null;
        }
  }

  // 전체 voice 생성
  @Transactional
  public VoiceRecords postVoiceRecords(String id,
      VoiceRecordsCreateRequest vr) {
    QuestionsKr questionsKr = questionsKrRepository.findById(vr.getQuestionsKrId());
    if (questionsKr == null) {
        throw new EntityNotFoundException("QuestionsKr not found");
    }
    VoiceRecords vRecords = new VoiceRecords(id, questionsKr,
         vr.getVoiceRecords(),vr.getSpeechToText(),vr.getMatchingRate());
    return voiceRecordsRepository.save(vRecords);
  }



}
