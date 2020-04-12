package Dao;

import entity.Account;

import java.util.List;

/**
 * @author YZY
 * @date 2020/4/6 - 21:01
 */
public interface IAccountDao {

    List<Account> findAll();
    Account findById(int id);

}
