package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author YZY
 * @date 2020/4/10 - 11:36
 */
@Data
public class Student {

    private int id;
    private String name;
//    学生需要关联一个老师
    private Teacher teacher;
}
