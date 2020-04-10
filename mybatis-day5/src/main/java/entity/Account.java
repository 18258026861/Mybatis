package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author YZY
 * @date 2020/4/6 - 21:01
 */
//get，set，toString，hashcode
@Data
//有参构造
@AllArgsConstructor
//无参构造
@NoArgsConstructor
public class Account {
    private int id;
    private String name;
    private float m;



}
