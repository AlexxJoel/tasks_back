package edu.utez.taskStudent.controller;

import edu.utez.taskStudent.models.student.Student;
import edu.utez.taskStudent.models.student.StudentRepository;
import edu.utez.taskStudent.models.teacher.Teacher;
import edu.utez.taskStudent.models.teacher.TeacherRepository;
import edu.utez.taskStudent.service.StudentService;
import edu.utez.taskStudent.service.TeacherService;
import edu.utez.taskStudent.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api-agenda/teacher")
@CrossOrigin(origins = {"*"})
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;


    @GetMapping("/{name}")
    public ResponseEntity<CustomResponse<Teacher>> getOne(@PathVariable("name") String name){
        return new ResponseEntity<>(
                new CustomResponse<>( this.teacherService.getByTeacherName(name), false, 200, "OK"),
                HttpStatus.OK
        );
    }






}
