package edu.utez.taskStudent.models.task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utez.taskStudent.models.student.Student;
import edu.utez.taskStudent.models.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private String start_date;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private String end_date;

    //joins
    @JsonIgnore

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

}
