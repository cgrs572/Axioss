package at.guigu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        //静态代码快会随着类的加载而自动执行，且只执行一次
        try {
            //配置mybatis-config.xml文件路径
            //注意：若该文件直接在resources目录下，则直接写文件名即可
            String resource = "mybatis-config.xml";
            //利用Resources类中的静态方法将配置文件加载到内存
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //获取SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
