package project.maru.instructure;

import org.springframework.data.jpa.repository.JpaRepository;
import project.maru.domain.UserLogInLogs;

public interface UserLoginLogsRepository extends JpaRepository<UserLogInLogs,Long> {

}
