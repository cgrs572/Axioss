package at.guigu.service;

import at.guigu.mapper.UserMapper;
import at.guigu.pojo.User;
import at.guigu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    //1 获取SqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     *登录方法
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        //2 获取SqlSession对象，执行SQL语句
        //2.1 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.2 获取Mapper接口UserMapper的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //2.3 执行sql语句
        User user = userMapper.select(username, password);
        //释放资源
        sqlSession.close();
        return user;
    }

    /**
     * 注册功能
     * @param user
     * @return
     */
    public boolean register(User user) {
        //2 获取SqlSession对象，执行SQL语句
        //2.1 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.2 获取Mapper接口UserMapper的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //3 判断用户名是否存在，若不存在则可添加用户
        User u = userMapper.selectByUsername(user.getUsername());
        if (u == null) {//用户名不存在,注册
            //4 执行sql语句
            userMapper.add(user);
            //5 注意：增删改的SQL语句需要手动提交事务让其生效
            sqlSession.commit();
        }
        //释放资源
        sqlSession.close();
        //当u!=null时代表用户名存在，会返回false；反之会返回true
        return u==null;
    }

    /**
     * 判断用户注册的用户名是否存在
     * @param username
     * @return
     */
    public boolean selectByUsername(String username) {
        //2 获取SqlSession对象，执行SQL语句
        //2.1 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.2 获取Mapper接口UserMapper的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //3 判断用户名是否存在
        User u = userMapper.selectByUsername(username);
        //释放资源
        sqlSession.close();
        //当u!=null时代表用户名存在，会返回false；反之会返回true
        return u==null;
    }
}