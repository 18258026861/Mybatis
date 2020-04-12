package Dao;

import entity.Account;
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
    private SqlSession sqlSession2;
    private IAccountDao iAccountDao;
    private IAccountDao iAccountDao2;
    private int result;
    @Before
    public void before(){
        //        获取sqlSession对象
         sqlSession = mybatisUtil.getSqlSession();
//         开启两个sqlsession
         sqlSession2 = mybatisUtil.getSqlSession();
         iAccountDao = sqlSession.getMapper(IAccountDao.class);
         iAccountDao2 = sqlSession2.getMapper(IAccountDao.class);
    }


    @Test
    public void findbyid2(){


    }

    @Test
    public void findbyid(){
        Account account = iAccountDao.findById(2);
        System.out.println(account);
//        一级缓存的数据关闭后会放入二级缓存
       sqlSession.close();
        Account account2 = iAccountDao2.findById(2);
        System.out.println(account2);
        System.out.println(account==account2);
    }



    @After
    public void close(){
        //        别忘了关闭session
//       sqlSession2.close();
    }
}
