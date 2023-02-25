package work.group.Call.center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.group.Call.center.entity.TelephoneOperator;

public interface TelephoneOperatorRepository extends JpaRepository<TelephoneOperator,Integer> {
}
