package school.digitazon.springtaskmanager.controller;
import jakarta.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import school.digitazon.springtaskmanager.entity.Tag;
import school.digitazon.springtaskmanager.entity.Task;
import school.digitazon.springtaskmanager.repository.TagRepository;
import school.digitazon.springtaskmanager.repository.TaskRepository;

@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TagRepository tagRepository;

    /* endpoint che legge tutti i task*/
    @GetMapping
    public List<Task> getAll(@RequestParam(name = "keyword", required = false) String s) {
        // testo se mi hai passato la stringa di ricerca (parametro keyword)
        if (Strings.isBlank(s)) {
            return taskRepository.findAll(); // se la stringa è vuota restituisco tutti i task
        } else {
            // se la stringa non è vuota restituisco i task filtrati
            return taskRepository.findByTaskContentContainingIgnoreCase(s);
        }
    }

    /* endpoint che legge un task preso per id*/
    @GetMapping("/{id}")
    public Task getById(@PathVariable Integer id) {

        Optional<Task> result = taskRepository.findById(id);
        // se il risultato è presente restituisco il contentuto che è il Task
        if (result.isPresent()) {
            return result.get(); // get prende il Task contenuto nell'Optional
        } else { // se il risultato è vuoto
            // return null;
            // chiudo il metodo con una Exception
            // e nella response ci sarà http status 404 not found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "task with id " + id + " not found");
        }
    }

    /* endpoint che crea un nuovo task e lo salva su db*/
    @PostMapping
    public Task create(@Valid @RequestBody Task task) {
        // valido che il task non sia esistente
        Optional<Task> result = taskRepository.findById(task.getId());
        // se il task non c'è già su database lo salvo (e sono sicura che è una insert)
        if (result.isEmpty()) {

            return taskRepository.save(task);
        } else {
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED,
                    "task with id " + task.getId() + " existing. Use PUT to update resource");
        }
    }

    /* endpoint che elimina un task per id*/
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        // controllo che il task esista
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);// lo elimino
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "task with id " + id + " not found");
        }
    }

    /* endpoint che aggiorna una risorsa presa per id */
    @PutMapping("/{id}")
    public Task update(@PathVariable Integer id, @Valid @RequestBody Task task) {
        Optional<Task> result = taskRepository.findById(id);
        if (result.isPresent()) {
            // persisto
            task.setId(id);
            return taskRepository.save(task);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "task with id " + id + " not found");
        }
    }

    /* endpoint che permette di aggiungere un Tag ad un Task preso per id
     * caso 1: il task non esiste -> http 404
     * caso 2: il task esiste e il tag esiste -> creo la relazione tra i due
     * caso 3: il task esiste e il tag non esiste -> creo il tag poi creo la relazione
     * */
    @PostMapping("/{id}/tags")
    public Set<Tag> addTag(@PathVariable Integer id, @RequestBody Tag tag) {
        Optional<Task> result = taskRepository.findById(id);
        if (result.isEmpty()) {
            // caso 1
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "task with id " + id + " not found");
        } else {
            // prendo il task da aggiornare
            Task task = result.get();
            // cerco su database un Tag con l'id passato nel body
            Optional<Tag> resultTag = tagRepository.findById(tag.getId());
            // questo è il tag che andrà aggiunto
            Tag tagToAdd = null;
            if (resultTag.isPresent() && resultTag.get().equals(tag)) {
                // caso 2
                tagToAdd = resultTag.get();
            } else {
                // caso 3
                // creo il nuovo tag
                Tag tagToCreate = new Tag(tag);
                tagToAdd = tagRepository.save(tagToCreate);
                // associo il tag creato al task

            }
            // adesso che ho un tag (nuovo o esistente) lo aggiungo alla relazione
            // gestisco eventuali Set null
            if (task.getTags() == null) {
                task.setTags(new HashSet<Tag>());
            }
            if (tagToAdd.getTasks() == null) {
                tagToAdd.setTasks(new HashSet<Task>());
            }
            // la relazione è mappata bidirezionalmente quindi devo aggiornare entrambi i lati
            task.getTags().add(tagToAdd); // aggiungo il tag alla lista del task
            tagToAdd.getTasks().add(task); // aggiungo il task alla lista del tag
            taskRepository.save(task);
            return task.getTags();
        }
    }

    /*
     * endpoint per rimuovere l'associazione tra un Task e un Tag presi per id
     * caso 1: Task esiste, Tag esiste -> rimuovo l'associazione
     * caso 2: Task non esiste -> http 404
     * caso 3: Tag non esiste -> http 404
     * */
    @DeleteMapping("/{id}/tags/{tag_id}")
    public Set<Tag> removeTag(@PathVariable("id") Integer taskId,
                              @PathVariable("tag_id") Integer tagId) {
        Optional<Task> taskResult = taskRepository.findById(taskId);
        Optional<Tag> tagResult = tagRepository.findById(tagId);
        if (tagResult.isPresent() && taskResult.isPresent()) {
            // caso 1
            // rimuovo associazione da entrambi i lati (in JAVA)
            Task task = taskResult.get();
            Tag tag = tagResult.get();
            task.getTags().remove(tag);
            tag.getTasks().remove(task);
            // salvo il task sul database
            taskRepository.save(task);
            return task.getTags();
        } else {
            // caso 2 e caso 3
            String message = "";
            if (taskResult.isEmpty()) {
                message += "task with id " + taskId + " not found\n";
            }
            if (tagResult.isEmpty()) {
                message += "tag with id " + tagId + " not found";
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
    }
}
