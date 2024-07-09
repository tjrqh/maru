package project.maru.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.maru.application.dto.VoiceRecordsDto.VoiceRecordsCreateRequest;
import project.maru.application.service.VoiceRecordsService;
import project.maru.domain.VoiceRecords;

@RestController
@RequestMapping("/voice")
public class VoiceRecordsController {

  @Autowired
  private VoiceRecordsService voiceRecordsService;


  @PostMapping("/uploads")
  public VoiceRecords postVoiceRecords(
      @RequestParam VoiceRecordsCreateRequest voiceRecordsCreateRequest) {
    return voiceRecordsService.postVoiceRecords(voiceRecordsCreateRequest);
  }
}
