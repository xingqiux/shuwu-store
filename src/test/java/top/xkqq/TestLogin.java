package top.xkqq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.xkqq.pojo.User;
import top.xkqq.service.UserService;

import java.time.LocalDateTime;

@SpringBootTest
public class TestLogin {

    @Autowired
    private UserService userService;

    @Test
//    插入一条记录
//测试注册功能服务
    public void testSave(){
        User user = new User();
        user.setUsername("youla");
        user.setPassword("ziyu.aurain");
        user.setEmail("ziyufg@gmail.com");
        user.setCreatedAt(LocalDateTime.now());
        userService.save(user);
    }

}
