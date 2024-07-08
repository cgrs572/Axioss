package at.guigu.mapper;

import at.guigu.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 根据用户名和密码查询用户对象
     * @param username
     * @param password
     * @return
     */
    //@Select("select * from tb_user where username=#{username} and password=#{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    //@Select("select * from tb_user where username=#{username}")
    User selectByUsername(String username);

    /**
     * 注册用户
     * @param user
     */
    //@Select("insert into tb_user(username, password) values (#{username}, #{password})")
    void add(User user);
}
