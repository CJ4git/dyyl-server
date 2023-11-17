package com.dyyl.dto.sys;

import com.dyyl.utils.HttpStatus;
import lombok.Data;

/**
 * 响应给前端的实体
 * @param <T> 响应数据泛型
 */
@Data
public class Response<T> {

    private Integer code;
    private String msg;
    private T data;

    private static Response<?> getThis() {
        return new Response<>();
    }

    public static Response<?> success() {
        return success(HttpStatus.SUCCESS.getMsg());
    }

    public static Response<?> success(String msg) {
        Response<?> response = getThis();
        response.setCode(HttpStatus.SUCCESS.getCode());
        response.setMsg(msg);
        return response;
    }

    public static <T> Response<T> success(T data) {
        return success(HttpStatus.SUCCESS.getMsg(),data);
    }

    public static <T> Response<T> success(String msg, T data) {
        Response<T> response = new Response<>();
        response.setCode(HttpStatus.SUCCESS.getCode());
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public static Response<?> error(String msg) {
        Response<?> response = getThis();
        response.setCode(HttpStatus.SERVERERROR.getCode());
        response.setMsg(msg);
        return response;
    }

}
