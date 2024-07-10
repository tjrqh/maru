package project.maru.application.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryRequest;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryResponse;
import project.maru.application.dto.LoginHistoryDto.PostLoginRequest;
import project.maru.instructure.UserLoginLogsRepository;

@Service
@RequiredArgsConstructor
public class LoginHistoryService {
  private final UserLoginLogsRepository userLoginLogsRepository;

  public GetLoginHistoryResponse findUserLoginHistory(GetLoginHistoryRequest getLoginHistoryRequest){

    return null;
  }

  public void insertUserLoginHistory(PostLoginRequest postLoginRequest){

  }



}
