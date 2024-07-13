package project.maru.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.maru.application.dto.userDto.UserTotalCountResponse;
import project.maru.infrastructure.UsersRepository;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UsersRepository usersRepository;

  public UserTotalCountResponse findTotalUserCount() {
    return UserTotalCountResponse.builder().userTotalCount(usersRepository.count()).build();
  }

}
