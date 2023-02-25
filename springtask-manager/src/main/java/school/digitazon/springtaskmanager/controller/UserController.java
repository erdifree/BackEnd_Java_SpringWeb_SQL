package school.digitazon.springtaskmanager.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import school.digitazon.springtaskmanager.entity.Task;
import school.digitazon.springtaskmanager.entity.User;
import school.digitazon.springtaskmanager.repository.TaskRepository;
import school.digitazon.springtaskmanager.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<User> getAll(
            @RequestParam(name = "firstname", required = false) String firstNameParam,
            @RequestParam(name = "lastname", required = false) String lastNameParam) {

        if (Strings.isNotBlank(firstNameParam) && Strings.isNotBlank(lastNameParam)) {
            // 1) sia firstname che lastname sono valorizzati
            return userRepository.findByFirstNameEqualsIgnoreCaseAndLastNameEqualsIgnoreCase(
                    firstNameParam, lastNameParam);
        } else if (Strings.isNotBlank(firstNameParam)) {
            // 2) solo firstname è valorizzato
            return userRepository.findByFirstNameEqualsIgnoreCase(firstNameParam);
        } else if (Strings.isNotBlank(lastNameParam)) {
            // 3) solo lastname è valorizzato
            return userRepository.findByLastNameEqualsIgnoreCase(lastNameParam);
        }
        // 4) nessuno dei due è valorizzato
        return userRepository.findAll(); // ritorno la lista non filtrata

    }

    @GetMapping("/{id}")
    public User getbyId(@PathVariable Integer id) {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            // restituisce lo user con quell'id
            return result.get();
        } else {
            // se non lo trova su database solleva un'eccezione con HTTP Status 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public User create(@Valid @RequestBody User newUser) {
        newUser.setId(0);// mi assicuro che abbia id vuoto
        return userRepository.save(newUser); // salvo lo user su database
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @Valid @RequestBody User user) {
        if (userRepository.existsById(id)) {
            // modifico lo user su database
            // restituisco lo user modificato
            user.setId(id);
            return userRepository.save(user);
        } else {
            // se non trovo l'utente con quell'id sollevo un'eccezione che ritorna HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if (userRepository.existsById(id)) {
            // elimino l'utente preso per id
            userRepository.deleteById(id);
        } else {
            // se non trovo l'utente con quell'id sollevo un'eccezione che ritorna HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /* controller per i task */
    @GetMapping("/{id}/tasks")
    public List<Task> getUserTasks(@PathVariable Integer id) {
        // verifico che lo user esiste
        Optional<User> result = userRepository.findById(id);
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user with id " + id + " not found");
        } else {
            User user = result.get();
            // restituisco i task dell'utente
            return user.getTasks(); // questo meglio
            // return taskRepository.findByOwner(user);
        }

    }

    @PostMapping("/{id}/tasks")
    public Task createUserTask(@Valid @RequestBody Task task, @PathVariable Integer id) {
        Optional<User> result = userRepository.findById(id);
        // controllo che ci sia lo user
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user with id " + id + " not found");
        } else {
            Task newTask = new Task();
            newTask.setTaskContent(task.getTaskContent());
            newTask.setDeadline(task.getDeadline());
            newTask.setCompleted(task.isCompleted());
            newTask.setOwner(result.get());

            // persisto il nuovo task su database
            return taskRepository.save(newTask);
        }
    }

}
