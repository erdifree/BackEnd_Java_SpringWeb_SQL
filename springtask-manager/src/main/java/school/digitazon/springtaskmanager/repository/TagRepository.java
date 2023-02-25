package school.digitazon.springtaskmanager.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import school.digitazon.springtaskmanager.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
