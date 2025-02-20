package top.xkqq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.xkqq.mapper.UserMapper;
import top.xkqq.pojo.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@SpringBootTest
public class TestUserMapper {

//    user 持久层测试

    @Autowired
    private UserMapper userMapper;
    @Test
//    增:插入一条记录
    public void UserInsert(){
        userMapper.deleteById(1);

        User user = new User();
        user.setUsername("ziyu");
        user.setPassword("012151");
        user.setEmail("aurain0@outlook.com");
        user.setCreatedAt(LocalDateTime.now());
        int insert = userMapper.insert(user);

        System.out.println("insert = " + insert);
    }



}
