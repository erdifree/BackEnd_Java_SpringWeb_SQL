package school.digitazon.springtaskmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(max = 55)
    private String name;
    @Size(min = 6, max = 6)
    private String color;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private Set<Task> tasks;

    // ci deve essere per forza per essere un bean
    public Tag() {
    }

    // questi servono a me per snellire il codice
    public Tag(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Tag(Tag copyTag) {
        this.name = copyTag.getName();
        this.color = copyTag.getColor();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Task> getTasks() {

        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Tag tag = (Tag) o;

        if (getId() != tag.getId()) {
            return false;
        }
        if (getName() != null ? !getName().equals(tag.getName()) : tag.getName() != null) {
            return false;
        }
        return getColor() != null ? getColor().equals(tag.getColor()) : tag.getColor() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        return result;
    }
}

