package edu.utez.taskStudent.service;

import edu.utez.taskStudent.dto.StudentDto;
import edu.utez.taskStudent.models.student.Student;
import edu.utez.taskStudent.models.student.StudentRepository;
import edu.utez.taskStudent.models.task.Task;
import edu.utez.taskStudent.models.task.TaskRepository;
import edu.utez.taskStudent.models.teacher.Teacher;
import edu.utez.taskStudent.models.teacher.TeacherRepository;
import edu.utez.taskStudent.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Student>> getByTeacher(String name) {

        Teacher teacher = this.teacherRepository.findByNameOrderByName(name);
        List<Task> taskList = this.taskRepository.findByTeacherOrderByStudent(teacher);
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        for (Task task : taskList) {
            if (student != task.getStudent()){
                student = task.getStudent();
                studentList.add(student);
            }
        }

        return new CustomResponse<>(studentList, false, 200, "OK");
    }


    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return new ArrayList<>(this.studentRepository.findAll());
    }


    @Transactional(readOnly = true)
    public List<Teacher> getAllTeacher() {
        return new ArrayList<>(this.teacherRepository.findAll());
    }



    @Transactional(readOnly = true)
    public List<Task>  findTeachersByStudent(Student student) {
        return new ArrayList<>(
                this.taskRepository.findByStudentOrderByTeacher(student)
        );
    }

    @Transactional(readOnly = true)
    public List<Task> getTasksBeetwenDates(String start, String end) {
        return new ArrayList<>(
                this.taskRepository.findByDates(start, end)
        );
    }


}
