package school.digitazon.springtaskmanager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import school.digitazon.springtaskmanager.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByFirstNameEqualsIgnoreCaseAndLastNameEqualsIgnoreCase(String firstName,
                                                                          String lastName);

    List<User> findByFirstNameEqualsIgnoreCase(String firsName);

    List<User> findByLastNameEqualsIgnoreCase(String lastName);
}

