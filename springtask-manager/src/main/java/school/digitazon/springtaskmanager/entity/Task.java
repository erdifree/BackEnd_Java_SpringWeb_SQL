package school.digitazon.springtaskmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity // obbligatoria
@Table(name = "tasks") // opzionale (se non c'è hibernate usa la sua namning strategy)
public class Task {

    @Id // obbligatoria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private int id;

    @NotBlank(message = "taskContent must not be blank")
    @Column(name = "content", nullable = false)
    private String taskContent; // task_content

    private boolean completed;

    @NotNull(message = "deadline must not be null")
    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User owner;

    @ManyToMany
    @JoinTable(name = "task_tag", joinColumns = {
            @JoinColumn(name = "task_id")}, inverseJoinColumns = {
            @JoinColumn(name = "tag_id")})
    private Set<Tag> tags;

    // Costruttori
    public Task() {
    } // costruttore vuoto di default NECESSARIO

    // Getter e Setter NECESSARI

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskContent() {
        return taskContent;
    }


    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    // campi calcolati con getter custom
    public boolean isExpired() {
        if (deadline != null && deadline.isBefore(LocalDate.now()) && !completed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskContent='" + taskContent + '\'' +
                ", completed=" + completed +
                ", deadline=" + deadline +
                ", owner=" + owner +
                '}';
    }
}

