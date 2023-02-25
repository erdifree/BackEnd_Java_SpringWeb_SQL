package school.digitazon.springtaskmanager.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import school.digitazon.springtaskmanager.entity.Tag;
import school.digitazon.springtaskmanager.entity.Task;
import school.digitazon.springtaskmanager.repository.TagRepository;

@RestController
@RequestMapping("/api/v1/tags")
@CrossOrigin
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @PostMapping
    public Tag createTag(@Valid @RequestBody Tag tag) {
        Tag newTag = new Tag(tag);
        return tagRepository.save(newTag);
    }

    /* endpoint che elimina un tag
     * caso 1: il tag non è associato a nessun task
     * caso 2: il tag è associato a uno o più task
     * */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        Optional<Tag> result = tagRepository.findById(id);
        if (result.isPresent()) {
            Tag tag = result.get();
            // rimuovo il tag da tutte le associazioni con i task
            Set<Task> associatedTasks = tag.getTasks();
            for (Task t : associatedTasks) {
                t.getTags().remove(tag);
            }
            // rimuovo tutti i task dal tag
            tag.setTasks(null);

            // adesso che non ci sono più associazioni cancello il tag
            tagRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "tag with id " + id + " not found");
        }
    }
}


