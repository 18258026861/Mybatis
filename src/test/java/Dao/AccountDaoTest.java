package Dao;

import static org.junit.Assert.assertTrue;

import entity.Account;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;
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
    public void findbyid(){

        List<Account> list = iAccountDao.findById(8);
        for(Object l : list){
            System.out.println(l);
        }
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

    @Test
    public void addaccounts(){
        Map<String, Object> map = new HashMap<String, Object>();
        /*map.put("name","cc");
        map.put("money",30000);*/
//        只会生效后面一个
        map.put("name","dd");
        map.put("money",400000);
         result = iAccountDao.addAccounts(map);
        System.out.println(result);
        sqlSession.commit();

    }

   @Test
   public void findbynamelike(){
//        模糊查找记得加上%%
       List<Account> byNameLike = iAccountDao.findByNameLike("%Y%");
       for(Object accoount : byNameLike){
           System.out.println(accoount);
       }
   }


    @After
    public void close(){
        //        别忘了关闭session
        sqlSession.close();
    }
}
