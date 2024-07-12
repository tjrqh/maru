package project.maru.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.maru.application.dto.voiceRecordsDto.VoiceRecordsCreateRequest;
import project.maru.application.service.VoiceRecordsService;
import project.maru.domain.VoiceRecords;
import project.maru.presentation.util.ParseToken;

@RestController
@RequestMapping("api/voice")
@RequiredArgsConstructor

public class VoiceRecordsController {

  private final VoiceRecordsService voiceRecordsService;
  private final ParseToken parseToken;


  @PostMapping("/uploads")
  public VoiceRecords postVoiceRecords(@RequestHeader("Authorization") String accessToken,
      @RequestBody VoiceRecordsCreateRequest voiceRecordsCreateRequest) throws Exception {
    String userId = parseToken.getParseToken(accessToken);
    return voiceRecordsService.postVoiceRecords(userId, voiceRecordsCreateRequest);
  }
}
