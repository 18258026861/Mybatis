package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author YZY
 * @date 2020/4/6 - 20:45
 */
// SqlSessionFactory -> sqlSession
public class mybatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null;
//    第一步：获取sqlSessionFactory对象
    static {
    String resource = "mybatis-config.xml";
    InputStream inputStream = null;

    try {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }
            }
//        第二步：通过sqlSessionFactory获取sqlSession，包含了我们需要的所有sql命令的方法
    public static SqlSession getSqlSession(){
//        参数选择true，自动提交事务
        return sqlSessionFactory.openSession(true);
    }
}
