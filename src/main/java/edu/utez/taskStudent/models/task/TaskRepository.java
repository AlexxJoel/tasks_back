package edu.utez.taskStudent.models.task;

import edu.utez.taskStudent.dto.StudentDto;
import edu.utez.taskStudent.models.student.Student;
import edu.utez.taskStudent.models.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


    List<Task> findByTeacherOrderByStudent(Teacher teacher);
    List<Task> findByStudentOrderByTeacher(Student student);

    Integer countByStudent(Student student);


    @Modifying
    @Query(value = "SELECT * FROM tasks WHERE :start_date>= start_date and :end_date<= end_date", nativeQuery = true)
    List<Task> findByDates(
            @Param("start_date") String start_date,
            @Param("end_date") String end_date
    );

}
