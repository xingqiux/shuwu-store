package top.xkqq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.xkqq.interceptor.JwtInterceptor;
import top.xkqq.mapper.UserMapper;


@Configuration
@SpringBootApplication
@MapperScan("top.xkqq.mapper")
public class Main implements WebMvcConfigurer {

    //配置拦截器
    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")    //拦截所有路径
                .excludePathPatterns("/user/login",
                                     "/user/register");
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }



}
