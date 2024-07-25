package michaelchursin.spring.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Name should not be empty!")
    @Pattern(regexp = "\\b([A-ZÀ-ÿ][-,a-z. ']+ *)+", message = "Name should start with a capital letter and not contain any numbers!")
    @Size(min = 2, max = 15, message = "Name should be between 2 and 15 characters!")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Surname should not be empty!")
    @Pattern(regexp = "\\b([A-ZÀ-ÿ][-,a-z. ']+ *)+", message = "Surname should start with a capital letter and not contain any numbers!")
    @Size(min = 2, max = 25, message = "Surname should be between 2 and 25 characters!")
    @Column(name = "surname")
    private String surname;

    @Digits(integer = 3, fraction = 0)
    @Positive(message = "Age should be greater than 0!")
    @Column(name = "age")
    private int age;

    public User() {
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String lastName) {
        this.surname = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", lastName='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
