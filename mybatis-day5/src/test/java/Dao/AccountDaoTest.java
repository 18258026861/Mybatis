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

         sqlSession = mybatisUtil.getSqlSession();

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
    public void findbyid(){
        Account account = iAccountDao.findNameById(4);
        System.out.println(account);

    }

    @Test
    public void findall(){
        List<Account> accounts = iAccountDao.findAll();
        for(Account account: accounts){
            System.out.println(account);
        }
    }

    @Test
    public void addaccount(){

        System.out.println(iAccountDao.addAccount(new Account(154,"YY",4000)));
    }

    @Test
    public void delete(){
        System.out.println(iAccountDao.delete(5));
    }


    @After
    public void close(){

        sqlSession.close();
    }
}
