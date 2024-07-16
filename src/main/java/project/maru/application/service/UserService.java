package project.maru.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.maru.infrastructure.UsersRepository;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UsersRepository usersRepository;

  public long findTotalUserCount() {
    return usersRepository.count();
  }

}
