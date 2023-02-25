package work.group.Call.center.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import work.group.Call.center.entity.Login;

import java.util.List;

public interface LoginRepository extends JpaRepository <Login, Integer> {

    List<Login> findByUsername(String username);
    Login findByUsernameAndPassword(String username,String password);

}
