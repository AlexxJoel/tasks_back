package edu.utez.taskStudent.models.student;


import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utez.taskStudent.models.task.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tuition; //matricula

    @Column(nullable = false)
    private String name;

    private String surname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private String dateOfBirth
            ;
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String gender;

    //join
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Task> taskList;



}
