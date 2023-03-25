package edu.utez.taskStudent.controller;


import edu.utez.taskStudent.dto.StudentDto;
import edu.utez.taskStudent.models.student.Student;
import edu.utez.taskStudent.models.task.Task;
import edu.utez.taskStudent.models.teacher.Teacher;
import edu.utez.taskStudent.service.StudentService;
import edu.utez.taskStudent.service.TaskService;
import edu.utez.taskStudent.service.TeacherService;
import edu.utez.taskStudent.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api-agenda/task")
@CrossOrigin(origins = {"*"})
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @GetMapping("/t/{teacher}")
    public ResponseEntity<CustomResponse<List<Student>>> getOne(@PathVariable("teacher") String teacher) {
        return new ResponseEntity<>(
                this.taskService.getByTeacher(teacher),
                HttpStatus.OK
        );
    }

    @GetMapping("/a/{student}")
    public  ResponseEntity<CustomResponse<List<Teacher>>> getTeachersByStudent(@PathVariable("student") String student){
        Student studentFind =  this.studentService.getStudent(student);
        List<Task> taskList = this.taskService.findTeachersByStudent(studentFind);
        List<Teacher> teacherList = new ArrayList<>();
        Teacher teacher = new Teacher();
        for(Task task: taskList){
            if (teacher != task.getTeacher()){
                teacher = task.getTeacher();
                teacherList.add(teacher);
            }
        }
        return new ResponseEntity<>(new CustomResponse<>( teacherList, false, 400, "OK"), HttpStatus.OK);

    }



    @GetMapping("/count/{name}")
    public ResponseEntity<CustomResponse<List<StudentDto>>> countTask(@PathVariable("name") String name) {
        List<Student> studentList = this.taskService.getAllStudents();
        List<Task> taskList = new ArrayList<>();
        Teacher teacher = this.teacherService.getByTeacherName(name);
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student s : studentList) {
            int count = 0;
            StudentDto student = new StudentDto(s.getTuition(), s.getName(), s.getSurname(), s.getDateOfBirth(), s.getLastname(), s.getEmail(), s.getPassword(), s.getGender());
            for (Task task : s.getTaskList()) {
                if (task.getTeacher() == teacher) {
                    System.out.println(s.getName());
                    count++;
                    System.out.println(task.getTitle() + count);
                    student.setNumberTasks(count);
                }
            }
            if (count != 0) {
                studentDtoList.add(student);
            }
        }
        return new ResponseEntity<>(new CustomResponse<>( studentDtoList, false, 400, "OK"), HttpStatus.OK);
    }



    @GetMapping("/date/{start}_{end}")
    public ResponseEntity<CustomResponse<List<Task>>> getOne(@PathVariable("start") String start, @PathVariable("end") String end) {
        return new ResponseEntity<>(
                new CustomResponse<>(this.taskService.getTasksBeetwenDates(start, end) , false, 400, "OK"),
                HttpStatus.OK
        );
    }


}
