package top.xkqq.interceptor;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.xkqq.util.JWTUtil;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //放行登录接口
        if (request.getRequestURI().contains("/user/login")){
            return true;
        }

        //从请求头获取 Token

        String token = request.getHeader("token");
        System.out.println(token);

        // toke 为 空
        if (token == null){
            response.setStatus(401);
            response.getWriter().write("token is null");
            return false;
        }

        //如果获取的token失效
        if(!JWTUtil.isTokenValid(token)){
            response.setStatus(401);
            response.getWriter().write("token error");
            return false;
        }
        //将载体中的信息提取出传入给请求
        Claims claims = JWTUtil.parsePayload(token);
        request.setAttribute("username",claims.get("username"));

        return true;
    }
}
