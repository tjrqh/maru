package project.maru.presentation;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryLoginCountRequest;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryLoginCountResponse;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryRequest;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryResponse;
import project.maru.application.dto.LoginHistoryDto.PostLoginRequest;
import project.maru.application.service.LoginHistoryService;
import project.maru.presentation.util.ParseToken;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login-history")
public class LoginHistoryController {

  private final LoginHistoryService LoginHistoryService;
  private final ParseToken parseToken;

  @GetMapping("")
  public List<GetLoginHistoryResponse> GetLoginHistory(
      @RequestHeader(value = "Authorization")
      @Parameter(name = "Authorization",in = ParameterIn.HEADER,
          schema = @Schema(accessMode = AccessMode.READ_ONLY))
      String accessToken,
      GetLoginHistoryRequest getLoginHistoryRequest) throws Exception {
    String userId = parseToken.getParseToken(accessToken);
    getLoginHistoryRequest.setUserId(userId);
    return LoginHistoryService.findUserLoginHistory(getLoginHistoryRequest);
  }
  @PostMapping("")
  public ResponseEntity<Void> PostLoginHistory(@RequestHeader(value = "Authorization") String accessToken,
      PostLoginRequest postLoginRequest) throws Exception {
    String userId = parseToken.getParseToken(accessToken);
    postLoginRequest.setUserId(userId);
    LoginHistoryService.insertUserLoginHistory(postLoginRequest);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/login-counts")
  public List<GetLoginHistoryLoginCountResponse> GetLoginCounts(@RequestHeader(value = "Authorization") String accessToken,
      GetLoginHistoryLoginCountRequest getLoginHistoryLoginCountRequest) throws Exception {
    String userId = parseToken.getParseToken(accessToken);
    getLoginHistoryLoginCountRequest.setUserId(userId);
    return LoginHistoryService.findUserLoginCount(getLoginHistoryLoginCountRequest);
  }
}
