package Dao;

import entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author YZY
 * @date 2020/4/10 - 22:03
 */
public interface IBlogDao {

    int addBlog(Blog blog);

    List<Blog> findBlog1(Map<String,Object> map);
    List<Blog> findBlog2(Map<String,Object> map);

}
