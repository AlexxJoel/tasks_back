package edu.utez.taskStudent.service;


import edu.utez.taskStudent.models.student.Student;
import edu.utez.taskStudent.models.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Transactional(readOnly = true)
    public Student getStudent(String name ) {
        return this.studentRepository.findByNameOrderByName(name);
    }




}
