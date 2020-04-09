package Dao;

import entity.Account;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.List;
import java.util.Map;

/**
 * @author YZY
 * @date 2020/4/6 - 21:01
 */
public interface IAccountDao {

    List<Account> findLimit(Map<String,Object> map);

    List<Account> findRowBounds(Map<String,Object> map);
}
