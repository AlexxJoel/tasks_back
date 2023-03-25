package edu.utez.taskStudent.dto;


import edu.utez.taskStudent.models.student.Student;
import edu.utez.taskStudent.models.task.Task;
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
public class StudentDto {

    private Long tuition; //matricula

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

    @NotEmpty(message = "Campo obligatorio")
    private int numberTasks;

    private Task task;

    public StudentDto(Long tuition, String name, String surname, String lastname, String dateOfBirth, String email, String password, String gender, int numberTasks) {
        this.tuition = tuition;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.numberTasks = numberTasks;
    }


    public StudentDto(Long tuition, String name, String surname,  String dateOfBirth, String lastname, String email, String password, String gender) {
        this.tuition = tuition;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }




}
