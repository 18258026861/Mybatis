package Dao;

import entity.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author YZY
 * @date 2020/4/6 - 21:01
 */
public interface IAccountDao {
    @Select("select * from account")
    List<Account> findAll();

    @Select("select * from account where id = #{id}")
//    有多个参数，所有参数前面需要增加@Param,参数名对应，一个参数不用加
    Account findNameById(@Param("id") int id);
    List<Account> findByName(String name);

    @Insert("insert into account values(id=#{id},name=#{name},money=#{m})")
    int addAccount(Account account);

    @Delete("delete from account where id = #{id}")
    int delete(int id);

}
