package work.group.Call.center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.group.Call.center.entity.PhoneCall;

import java.util.List;

public interface PhoneCallRepository extends JpaRepository<PhoneCall, Integer> {
        //List<PhoneCall> findById_sub(Integer idsub);
}
