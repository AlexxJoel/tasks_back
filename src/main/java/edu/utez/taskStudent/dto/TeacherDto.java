package edu.utez.taskStudent.dto;


import edu.utez.taskStudent.models.task.Task;
import edu.utez.taskStudent.models.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherDto {

    private Long numberWorker;

    @NotEmpty(message = "Campo obligatorio")
    private String name;
    private String surname;

    @NotEmpty(message = "Campo obligatorio")
    private String lastname;

    @NotEmpty(message = "Campo obligatorio")
    private String dateOfBirth;

    @NotEmpty(message = "Campo obligatorio")
    private String email;

    @NotEmpty(message = "Campo obligatorio")
    private String password;

    @NotEmpty(message = "Campo obligatorio")
    private String gender;

    private Task task;

    public Teacher getTeacher() {
        return new Teacher(
                getNumberWorker(),
                getName(),
                getSurname(),
                getLastname(),
                getDateOfBirth(),
                getEmail(),
                getPassword(),
                getGender(),
                (List<Task>) getTask()
        );
    }
}
