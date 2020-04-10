package Dao;
import entity.Blog;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.mybatisUtil;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AccountDaoTest {

    private SqlSession sqlSession;
    private Blog blog;
    private IBlogDao iBlogDao;
    private Logger logger;
    private int result;

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Before
    public void before(){
        sqlSession = mybatisUtil.getSqlSession();
        iBlogDao = sqlSession.getMapper(IBlogDao.class);
    }

    @Test
    public void addblog(){
        Blog blog2 = new Blog(getId(),"blog5","YZY",new Date(),5400);
        System.out.println(iBlogDao.addBlog(blog2));
//        提交事务别忘了!!
        sqlSession.commit();
    }

    @Test
    public void findBlog1(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("author","YY");
//        map.put("views",7000);
        List<Blog> blog1 = iBlogDao.findBlog1(map);
        for(Blog blog: blog1){
            System.out.println(blog);
        }
    }

    @Test
    public void findBlog2(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("author","YY");
        map.put("views",7000);
        map.put("title","blog3");
//
        List<Blog> blog2 = iBlogDao.findBlog2(map);
        for(Blog blog: blog2){
            System.out.println(blog);
        }
    }


    @After
    public void close(){
        //        别忘了关闭session
        sqlSession.close();
    }
}
