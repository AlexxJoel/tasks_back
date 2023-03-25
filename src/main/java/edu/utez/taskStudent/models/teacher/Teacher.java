package edu.utez.taskStudent.models.teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utez.taskStudent.models.task.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numberWorker;

    @Column(nullable = false)
    private String name;

    private String surname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private String dateOfBirth;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String gender;


    //joins
    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Task> taskList;

}
