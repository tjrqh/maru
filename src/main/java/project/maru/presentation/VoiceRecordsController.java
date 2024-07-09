package project.maru.presentation;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.maru.application.dto.VoiceRecordsDto.VoiceRecordsCreateRequest;
import project.maru.application.service.VoiceRecordsService;
import project.maru.domain.VoiceRecords;
import project.maru.presentation.util.CognitoJWTParser;

@RestController
@RequestMapping("/voice")
public class VoiceRecordsController {

  @Autowired
  private VoiceRecordsService voiceRecordsService;

  @Autowired
  private CognitoJWTParser cognitoJWTParser;


  @PostMapping("/uploads")
  public VoiceRecords postVoiceRecords(@RequestHeader("Authorization") String accessToken,
      @RequestBody VoiceRecordsCreateRequest voiceRecordsCreateRequest) throws Exception {
    DecodedJWT cognitoToken = cognitoJWTParser.parseToken(accessToken);
    String sub = cognitoToken.getClaims().get("sub").toString();
    String userId = sub.replaceAll("^\"|\"$", ""); // 앞뒤 큰따옴표 제거
    voiceRecordsCreateRequest.setUserId(userId);
    System.out.println(voiceRecordsCreateRequest);
    return voiceRecordsService.postVoiceRecords(voiceRecordsCreateRequest);
  }
}
