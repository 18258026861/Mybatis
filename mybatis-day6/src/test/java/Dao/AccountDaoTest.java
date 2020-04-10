package Dao;

import entity.Student;
import entity.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.mybatisUtil;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AccountDaoTest {

    private SqlSession sqlSession;
    private ITeacherDao iTeacherDao;
    private IStudentDao iStudentDao;
    private int result;
    @Before
    public void before(){

         sqlSession = mybatisUtil.getSqlSession();

         iTeacherDao = sqlSession.getMapper(ITeacherDao.class);
         iStudentDao = sqlSession.getMapper(IStudentDao.class);
    }
    @Test
    public void getStudentbyid(){
        Student student = iStudentDao.getStudentById(1);
        System.out.println(student);
    }


    @Test
    public void getStudent(){
        List<Student> students = iStudentDao.getStudent();
        for(Student student : students){
            System.out.println(student);
        }
    }
    @Test
    public void getStudent2(){
        List<Student> students = iStudentDao.getStudent2();
        for(Student student : students){
            System.out.println(student);
        }
    }
    @Test
    public void getTeacher(){
        List<Teacher> teacher = iTeacherDao.getTeacher();
        for(Teacher teacher1:teacher){
            System.out.println(teacher1);
        }
    }


    @After
    public void close(){

        sqlSession.close();
    }
}
