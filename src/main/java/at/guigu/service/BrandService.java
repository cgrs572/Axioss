package at.guigu.service;

import at.guigu.mapper.BrandMapper;
import at.guigu.pojo.Brand;
import at.guigu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;


public class BrandService {

    //1 获取SqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 查询所有
     * @return
     * @throws IOException
     */
    public List<Brand> getAll() throws IOException {

        //2 获取SqlSession对象，执行SQL语句
        //2.1 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.2 获取Mapper接口UserMapper的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //2.3 执行sql语句
        List<Brand> brands = brandMapper.selectAll();

        sqlSession.close();
        return brands;
    }
    /**
     * 添加品牌
     * @param brand
     */
    public void add(Brand brand){
        //2 获取SqlSession对象，执行SQL语句
        //2.1 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.2 获取Mapper接口UserMapper的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //2.3 执行添加品牌的sql语句
        brandMapper.add(brand);

        //3 注意：增删改的SQL语句需要手动提交事务让其生效
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    /**
     * 修改——回显数据：根据id查询
     * @param id
     * @return
     */
    public Brand selectById(int id){
        //2 获取SqlSession对象，执行SQL语句
        //2.1 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.2 获取Mapper接口UserMapper的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //2.3 执行修改——回显数据的sql语句
        Brand brand = brandMapper.selectById(id);
        //释放资源
        sqlSession.close();
        return brand;
    }

    /**
     * 修改——修改数据
     * @param brand
     */
    public void update(Brand brand) {
        //2 获取SqlSession对象，执行SQL语句
        //2.1 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.2 获取Mapper接口UserMapper的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //2.3 执行修改——修改数据的sql语句
        brandMapper.update(brand);

        //3 注意：增删改的SQL语句需要手动提交事务让其生效
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }
}
