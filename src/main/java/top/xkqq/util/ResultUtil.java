package top.xkqq.util;

import top.xkqq.util.result.Result;
import top.xkqq.util.result.ResultEnum;

public class ResultUtil {

    //成功，返回数据
    public static <T> Result<T> defineSuccess(Integer code,T data){
        Result result = new Result<>();
        result.setCode(code);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.code);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(String msg) {
        Result result = new Result();
        result.setCode(ResultEnum.FAIL.code);
        result.setMessage(msg);
        return result;
    }

    public static <T> Result<T> defineFail(int code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    public static <T> Result<T> define(int code, String msg, T data){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }
}
