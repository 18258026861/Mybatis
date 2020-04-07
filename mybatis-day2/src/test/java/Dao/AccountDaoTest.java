package Dao;

import entity.Account;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.mybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
//    增删改需要了提交事务
    public void addaccount(){
        Account account = new Account(113,"UU",3000);
         result = iAccountDao.addAccount(account);
        System.out.println(result);
//        提交事务
        sqlSession.commit();
    }

    @Test
    public void updateaccount(){
        Account account = new Account(3,"YY",10000);
         result = iAccountDao.updateAccount(account);
        System.out.println(result);
        sqlSession.commit();
    }

    @Test
    public void deleteaccount(){
         result = iAccountDao.deleteAccount(113);
        System.out.println(result);
        sqlSession.commit();
    }


    @After
    public void close(){
        //        别忘了关闭session
        sqlSession.close();
    }
}
