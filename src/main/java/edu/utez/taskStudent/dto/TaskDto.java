package edu.utez.taskStudent.dto;


import edu.utez.taskStudent.models.student.Student;
import edu.utez.taskStudent.models.task.Task;
import edu.utez.taskStudent.models.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDto {

    private Long id;

    @NotEmpty(message = "Campo obligatorio")
    private String title;

    @NotEmpty(message = "Campo obligatorio")
    private String description;

    @NotEmpty(message = "Campo obligatorio")
    private String start_date;

    @NotEmpty(message = "Campo obligatorio")
    private String end_date;

    private Long student_id;
    private Long teacher_id;

    public Task task(){
        return  new Task(
                getId(),
                getTitle(),
                getDescription(),
                getStart_date(),
                getEnd_date(),
                new Student(student_id, "", "" , "", "", "" , "", "", null),
                new Teacher(teacher_id, "", "" , "", "", "" , "", "", null)
        );
    }

}
