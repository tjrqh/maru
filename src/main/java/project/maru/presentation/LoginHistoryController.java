package project.maru.presentation;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.AddDefaultCharsetFilter.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryCalendarResponse;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryLoginCountRequest;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryLoginCountResponse;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryRequest;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryResponse;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryTodayCountResponse;
import project.maru.application.dto.LoginHistoryDto.PostLoginRequest;
import project.maru.application.dto.ResponseStatus;
import project.maru.application.dto.SimpleApiResponse;
import project.maru.application.service.LoginHistoryService;
import project.maru.presentation.util.ParseToken;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login-history")
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

  @PostMapping("")
  @Operation(summary = "로그인 기록 추가", responses = {
      @ApiResponse(responseCode = "201", description = "successfully",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = SimpleApiResponse.class)))
  })
  @Schema(example = "{\"status\":\"success\", \"message\":\"userId logged in!\", \"data\":null}")
  public SimpleApiResponse<?> PostLoginHistory(
      @RequestHeader(value = "Authorization") @Parameter(name = "Authorization", in = ParameterIn.HEADER, schema = @Schema(hidden = true)) String accessToken,
      PostLoginRequest postLoginRequest) throws Exception {
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
  public GetLoginHistoryTodayCountResponse GetLoginCountsToday(
      @RequestHeader(value = "Authorization") @Parameter(name = "Authorization", in = ParameterIn.HEADER, schema = @Schema(hidden = true)) String accessToken)
      throws Exception {
    return LoginHistoryService.findTodayLoginTotal();
  }

  @GetMapping("/calendar")
  @Operation(summary = "이번달 로그인 이력 조회")
  public List<GetLoginHistoryCalendarResponse> GetLoginCalendar(
      @RequestHeader(value = "Authorization") @Parameter(name = "Authorization", in = ParameterIn.HEADER, schema = @Schema(hidden = true)) String accessToken)
      throws Exception {
    String userId = parseToken.getParseToken(accessToken);
    return LoginHistoryService.findUserLoginCalendar(userId);
  }

}
