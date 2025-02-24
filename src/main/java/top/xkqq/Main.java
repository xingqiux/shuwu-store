package top.xkqq;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.xkqq.interceptor.JwtInterceptor;
@Configuration
@SpringBootApplication
@MapperScan("top.xkqq.mapper")
public class Main implements WebMvcConfigurer {

    //配置拦截器
    @Autowired
    private JwtInterceptor jwtInterceptor;

    //配置拦截器拦截的请求
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")    //拦截所有路径
                .excludePathPatterns("/user/login",
                                     "/user/register",
                                     "/swagger-ui.html",
                                     "/swagger-ui/**",
                                     "/v3/api-docs/**");
    }
    @Bean
    //配置MyBatis Plus 插件
    //分页插件
    public MybatisPlusInterceptor plusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }



}
