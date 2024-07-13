package project.maru.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.maru.application.dto.UserDto.UserTotalCountResponse;
import project.maru.instructure.UsersRepository;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UsersRepository usersRepository;

  public UserTotalCountResponse findTotalUserCount() {
    return UserTotalCountResponse.builder().userTotalCount(usersRepository.count()).build();
  }

}
