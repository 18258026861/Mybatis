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
    private IAccountDao iAccountDao;
    private int result;
    @Before
    public void before(){
        //        获取sqlSession对象
         sqlSession = mybatisUtil.getSqlSession();
//        使用sqlSession的sql调用语句
         iAccountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @Test
    public void findbyname(){

        List<Account> list1 = iAccountDao.findByName("YY");
        for(Account account:list1){
            System.out.println(account);
        }
    }



    @After
    public void close(){
        //        别忘了关闭session
        sqlSession.close();
    }
}
