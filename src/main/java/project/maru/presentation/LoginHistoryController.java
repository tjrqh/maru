package project.maru.presentation;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.maru.application.dto.ResponseStatus;
import project.maru.application.dto.SimpleApiResponse;
import project.maru.application.dto.loginHistoryDto.GetLoginHistoryCalendarResponse;
import project.maru.application.dto.loginHistoryDto.GetLoginHistoryLoginCountRequest;
import project.maru.application.dto.loginHistoryDto.GetLoginHistoryLoginCountResponse;
import project.maru.application.dto.loginHistoryDto.GetLoginHistoryRequest;
import project.maru.application.dto.loginHistoryDto.GetLoginHistoryResponse;
import project.maru.application.dto.loginHistoryDto.PostLoginRequest;
import project.maru.application.service.LoginHistoryService;
import project.maru.presentation.util.ParseToken;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginHistoryController {

  private final LoginHistoryService LoginHistoryService;
  private final ParseToken parseToken;

  @GetMapping("")
  @Operation(deprecated = true)
  public List<GetLoginHistoryResponse> GetLoginHistory(
      @RequestHeader(value = "Authorization") @Parameter(name = "Authorization", in = ParameterIn.HEADER, schema = @Schema(hidden = true)) String accessToken,
      GetLoginHistoryRequest getLoginHistoryRequest) throws Exception {
    String userId = parseToken.getParseToken(accessToken);
    getLoginHistoryRequest.setUserId(userId);
    return LoginHistoryService.findUserLoginHistory(getLoginHistoryRequest);
  }

  @PostMapping("user-info")
  @Operation(summary = "로그인 기록 추가", responses = {
      @ApiResponse(responseCode = "201", description = "successfully",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = SimpleApiResponse.class)))
  })
  @Schema(example = "{\"status\":\"success\", \"message\":\"userId logged in!\", \"data\":null}")
  public SimpleApiResponse<?> PostLoginHistory(
      @RequestHeader(value = "Authorization")
      @Parameter(name = "Authorization", in = ParameterIn.HEADER, schema = @Schema(hidden = true))
      String accessToken,
      @RequestBody PostLoginRequest postLoginRequest) throws Exception {
    String userId = parseToken.getParseToken(accessToken);
    postLoginRequest.setUserId(userId);
    LoginHistoryService.insertUserLoginHistory(postLoginRequest);

    return SimpleApiResponse.builder().
        message(userId + " logged in!")
        .status(ResponseStatus.SUCCESS).build();
  }

  @GetMapping("/login-counts")
  @Operation(deprecated = true)
  public List<GetLoginHistoryLoginCountResponse> GetLoginCounts(
      @RequestHeader(value = "Authorization") @Parameter(name = "Authorization", in = ParameterIn.HEADER, schema = @Schema(hidden = true)) String accessToken,
      GetLoginHistoryLoginCountRequest getLoginHistoryLoginCountRequest) throws Exception {
    String userId = parseToken.getParseToken(accessToken);
    getLoginHistoryLoginCountRequest.setUserId(userId);
    return LoginHistoryService.findUserLoginCount(getLoginHistoryLoginCountRequest);
  }

  @Operation(summary = "오늘 로그인한 회원 수")
  @GetMapping("/total/today")
  public project.maru.application.dto.loginHistoryDto.GetLoginHistoryTodayCountResponse GetLoginCountsToday(
      @RequestHeader(value = "Authorization") @Parameter(name = "Authorization", in = ParameterIn.HEADER, schema = @Schema(hidden = true)) String accessToken)
      throws Exception {
    return LoginHistoryService.findTodayLoginTotal();
  }

  @GetMapping("/attendance")
  @Operation(summary = "이번달 로그인 이력 조회")
  public List<LocalDate> GetLoginCalendar(
      @RequestHeader(value = "Authorization") @Parameter(name = "Authorization", in = ParameterIn.HEADER, schema = @Schema(hidden = true)) String accessToken)
      throws Exception {
    String userId = parseToken.getParseToken(accessToken);
    return LoginHistoryService.findUserLoginCalendar(userId);
  }

}
