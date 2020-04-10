package Dao;

import entity.Student;
import entity.Teacher;

import java.util.List;

/**
 * @author YZY
 * @date 2020/4/10 - 11:55
 */
public interface IStudentDao {

    List<Student> getStudent();
    List<Student> getStudent2();
    Student getStudentById(int id);



}
