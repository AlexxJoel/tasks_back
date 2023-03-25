package edu.utez.taskStudent.models.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {

    Student findByTuitionOrderByPassword(Long tuition);
    Student findByNameOrderByName(String name);


}
