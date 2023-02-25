package school.digitazon.springtaskmanager.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import school.digitazon.springtaskmanager.entity.Task;
import school.digitazon.springtaskmanager.entity.User;

// estendo JpaRepository così ne eredito tutti i metodi, e specifico
// che tipo di oggetti gestisce (Task) e che tipo di chiave primaria (int->Integer)
public interface TaskRepository extends JpaRepository<Task, Integer> {

    // select * from tasks where content like '%...%'
    List<Task> findByTaskContentContainingIgnoreCase(String keyword);

    List<Task> findByCompletedEquals(boolean completed); // fatta con query method

    @Query("select t from Task t where t.completed = :p1")
        // fatta in JPQL (Java Persistence Query Language)
    List<Task> getCompletedJPQL(@Param("p1") boolean parameter);

    @Query(value = "select * from tasks where completed = :p1", nativeQuery = true)
        // fatta in SQL nativo
    List<Task> getCompletedSQL(@Param("p1") boolean parameter);

    // restituisce tutti i task il cui campo completed è uguale a quello che ti passo
    // e la cui data scadenza sia compresa tra due date che ti passo
    List<Task> findByCompletedEqualsAndDeadlineBetween(boolean completed, LocalDate start,
                                                       LocalDate end);

    List<Task> findByOwner(User user);

}
