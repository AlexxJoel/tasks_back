package edu.utez.taskStudent.service;


import edu.utez.taskStudent.models.teacher.Teacher;
import edu.utez.taskStudent.models.teacher.TeacherRepository;
import edu.utez.taskStudent.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class TeacherService {

    @Autowired
    private TeacherRepository repository;


    @Transactional(readOnly = true)
    public Teacher getByTeacherName(String name){
        return this.repository.findByNameOrderByName(name);
    }

}
