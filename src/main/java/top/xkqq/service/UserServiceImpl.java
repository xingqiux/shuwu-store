package top.xkqq.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import top.xkqq.mapper.UserMapper;
import top.xkqq.pojo.User;

@Component
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
