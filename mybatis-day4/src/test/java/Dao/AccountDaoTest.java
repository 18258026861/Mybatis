package Dao;

import entity.Account;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.mybatisUtil;
import org.apache.log4j.Logger;

import java.util.*;

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
//    sql语句limit实现分页
    public void findLimit(){
        logger = Logger.getLogger(IAccountDao.class);
        logger.info("开始执行findall=========");
        Map<String,Object> map = new HashMap<String,Object>();
            map.put("startIndex",3);
            map.put("pageSize",5);
        List<Account> all = iAccountDao.findLimit(map);
        for(Object o : all){
            System.out.println(o);
        }
        logger.info("执行findall结束");
    }

    @Test
    //        从java代码方式实现分页
    public void findrowbounds(){
//                          创建rowbounds，startIndex，pageSize
        RowBounds rowBounds = new RowBounds(1, 5);

        List<Object> objects = sqlSession.selectList("Dao.IAccountDao.findRowBounds",null,rowBounds);
        for(Object o : objects){
            System.out.println(o);
        }
    }

    @After
    public void close(){
        //        别忘了关闭session
        sqlSession.close();
    }
}
