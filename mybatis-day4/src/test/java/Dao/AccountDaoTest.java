package Dao;

import entity.Account;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.mybatisUtil;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AccountDaoTest {

    private SqlSession sqlSession;
    private IAccountDao iAccountDao;
    private Logger logger;
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
    public void findById(){
        logger = Logger.getLogger(IAccountDao.class);
        logger.info("开始info方法======================");
        logger.debug("debug------------------");
        logger.error("error-----------------");
        System.out.println(iAccountDao.findNameById(8));
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
    public void testlog(){
         logger = Logger.getLogger(IAccountDao.class);
         logger.info("info--");
         logger.debug("debug--");
         logger.error("error--");
    }



    @Test
    public void deleteaccount(){
        result = iAccountDao.deleteAccount(113);
        System.out.println(result);
        sqlSession.commit();
    }

    @Test
    public void findLimit(){
        logger = Logger.getLogger(IAccountDao.class);
        logger.info("开始执行findall=========");
        List<Account> all = iAccountDao.findLimit();
        for(Object o : all){
            System.out.println(o);
        }
        logger.info("执行findall结束");
    }




    @After
    public void close(){
        //        别忘了关闭session
        sqlSession.close();
    }
}
