package top.xkqq.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.xkqq.pojo.User;
import top.xkqq.service.UserService;
import top.xkqq.util.JWTUtil;
import top.xkqq.util.MD5Util;
import top.xkqq.util.ResultUtil;
import top.xkqq.util.result.Result;

import java.time.LocalDateTime;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //获取当前用户的短信消息
    @GetMapping("msg")
    public Result<Object> checkUserName(@RequestBody User user){
        String userMsg = "";
        if (user.getUsername().equals("youla1")){
            userMsg = "hello world";
        }
        return ResultUtil.success(userMsg);
    }


    //校验邮箱是否被使用


    //用户注册
    @PostMapping("register")
    public Result<Object> userRegister(@RequestBody User user){
        //查询用户名称是否已存在
        if(userService.lambdaQuery().eq(User::getUsername, user.getUsername()).exists() ||
           userService.lambdaQuery().eq(User::getUsername,user.getEmail()).exists()){
            return ResultUtil.fail("user or email exists");
        }

        //如果不存在直接添加

        //获取创建用户的时间
        user.setCreatedAt(LocalDateTime.now());
        //对密码进行MD5加密
        user.setPassword(MD5Util.md5(user.getPassword()));
        userService.save(user);

        return ResultUtil.success(user);
    }

    //用户登录
    @PostMapping("login")
    public Result<Object> userLogin(@RequestBody User user){

        User dbUser = userService.lambdaQuery().eq(User::getUsername, user.getUsername()).one();
        String userPasswordMd5 = MD5Util.md5(user.getPassword());

        //检验用户是否存在以及密码是否正确
        if (dbUser == null || !(dbUser.getPassword().equals(userPasswordMd5))) {
            return ResultUtil.fail("password or user mistake");
        }
        //生成 JWT Token 与返回 dbUser id
        user.setToken(JWTUtil.genAccessToken(user.getUsername()));
        user.setId(dbUser.getId());

        return ResultUtil.success(user);
    }




}
