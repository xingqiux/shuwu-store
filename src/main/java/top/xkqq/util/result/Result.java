package top.xkqq.util.result;


import lombok.Data;

@Data
public class Result<T> {
    private Integer code; //状态码
    private String message;//返回信息
    private T data; //返回如用户信息
}
