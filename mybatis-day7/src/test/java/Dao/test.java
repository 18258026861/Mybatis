package Dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.Teacher;
import utils.mybatisUtil;

import java.util.List;

/**
 * @author YZY
 * @date 2020/4/10 - 16:27
 */
public class test {

    private SqlSession sqlSession;
    private ITeacherDao iTeacherDao;


    @Before
    public void before(){
        sqlSession = mybatisUtil.getSqlSession();
        iTeacherDao = sqlSession.getMapper(ITeacherDao.class);
    }
    @Test
    public void getteacher(){
        List<Teacher> teachers = iTeacherDao.getTeacher();
        System.out.println(teachers);
    }
    @Test
    public void getstudentbyteacher(){
        Teacher teacher = iTeacherDao.getStudentByTeacher(1);
        System.out.println(teacher);
    }

    @After
    public void close(){
        sqlSession.close();
    }
}
