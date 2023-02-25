package school.digitazon.springtaskmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import school.digitazon.springtaskmanager.entity.Task;
import school.digitazon.springtaskmanager.entity.User;
import school.digitazon.springtaskmanager.repository.TaskRepository;
import school.digitazon.springtaskmanager.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;


@Component
public class TestRepo implements CommandLineRunner {

    private final static Logger logger = LoggerFactory.getLogger(TestRepo.class);
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
  /*      System.out.println( "test -----------");
        List<Task> allTasks = taskRepository.findAll();
        System.out.println("allTasks");
        System.out.println(allTasks);

      

        List<Task> notCompletedTasks = taskRepository.findByCompletedEquals(false);
        List<Task> completedTasks = taskRepository.findByCompletedEquals(true);
        System.out.println("Completed tasks");
        System.out.println(completedTasks);
        System.out.println("Not completed tasks");
        System.out.println(notCompletedTasks);

       // LocalDate start = LocalDate.of(2000,01,01);
        LocalDate end = LocalDate.of(2025,12,30);
        List<Task> query= taskRepository.findByCompletedEqualsAndDeadlineBetween(true,LocalDate.parse("2000-01-01"),end);
        System.out.println("++++++++++++++++++++ completed e between +++++++++++++++++++");
        System.out.println(query);


        System.out.println("**************************************");
        List<Task> jpql= taskRepository.getJPQL(false);
        System.out.println(jpql);*/

       /* User user1=userRepository.findById(1).get();

        System.out.println(user1);

        Task task=new Task();

        task.setContent("test mapping relationship");
        task.setDeadline(LocalDate.now());
        task.setUser_id(user1);
        Task createdTask=taskRepository.save(task);
        System.out.println();*/

    }






}

