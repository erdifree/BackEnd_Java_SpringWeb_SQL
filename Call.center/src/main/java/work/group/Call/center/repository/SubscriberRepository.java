package work.group.Call.center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.group.Call.center.entity.Subscriber;

import java.util.List;

public interface SubscriberRepository extends JpaRepository<Subscriber,Integer> {

   Subscriber findByFirstnameEqualsIgnoreCase (String nome);

}
