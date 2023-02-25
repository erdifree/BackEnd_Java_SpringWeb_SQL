package work.group.Call.center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.group.Call.center.entity.Layout;

public interface LayoutRepository extends JpaRepository<Layout,Integer> {

    Layout findByChiaveEqualsIgnoreCase (String string);
}
