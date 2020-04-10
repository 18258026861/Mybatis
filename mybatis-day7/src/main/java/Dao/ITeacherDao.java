package Dao;

import entity.Teacher;

import java.util.List;

/**
 * @author YZY
 * @date 2020/4/10 - 16:22
 */
public interface ITeacherDao {

        List<Teacher> getTeacher();
//        获取指定老师下的所有学生
        Teacher getStudentByTeacher(int id);
        Teacher getStudentByTeacher2(int id);

}
