package at.guigu.json;

import at.guigu.pojo.User;
import com.alibaba.fastjson.JSON;

public class FastJsonDemo1 {
    public static void main(String[] args) {
        //1 将Java对象转为JSON字符串
        //1.1 创建User对象
        User user = new User();
        user.setId(10);
        user.setUsername("xiaofei");
        user.setPassword("123");
        //1.2 将User对象转为JSON字符串
        String jsonStr = JSON.toJSONString(user);
        System.out.println(jsonStr);

        //2 将JSON字符串转为指定的Java对象
        User user1 = JSON.parseObject("{\"id\":10,\"password\":\"123\",\"username\":\"xiaofei\"}", User.class);
        System.out.println(user1);
    }
}