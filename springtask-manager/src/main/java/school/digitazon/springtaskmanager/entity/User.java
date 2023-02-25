package school.digitazon.springtaskmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String username;
    @NotBlank
    //@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).{6,8}$", message = "password must be between 6 and 8 characters and include a capital letter")
    private String password;
    private String firstName;
    private String lastName;
    @PastOrPresent
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "owner", orphanRemoval = true)
    private List<Task> tasks;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (getId() != user.getId()) {
            return false;
        }
        if (getUsername() != null ? !getUsername().equals(user.getUsername())
                : user.getUsername() != null) {
            return false;
        }
        if (getPassword() != null ? !getPassword().equals(user.getPassword())
                : user.getPassword() != null) {
            return false;
        }
        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName())
                : user.getFirstName() != null) {
            return false;
        }
        if (getLastName() != null ? !getLastName().equals(user.getLastName())
                : user.getLastName() != null) {
            return false;
        }
        return getDateOfBirth() != null ? getDateOfBirth().equals(user.getDateOfBirth())
                : user.getDateOfBirth() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        return result;
    }
}
