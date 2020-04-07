package Dao;

import entity.Account;

import java.util.List;
import java.util.Map;

/**
 * @author YZY
 * @date 2020/4/6 - 21:01
 */
public interface IAccountDao {
    String findNameById(int id);
    List<Account> findById(int id);
    List<Account> findByName(String name);
    int addAccount(Account account);
    int updateAccount(Account account);
    int deleteAccount(int id);
    int addAccounts(Map<String,Object> map);
    List<Account> findByNameLike(String name);
}
