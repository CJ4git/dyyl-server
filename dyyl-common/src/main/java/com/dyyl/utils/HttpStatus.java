package com.dyyl.utils;

public enum HttpStatus {

    SUCCESS(200,"请求成功！"),
    UNAUTHORIZED(401,"没有权限！"),
    TOKEN_EXPIRED(501,"登录超时！"),
    SERVERERROR(500,"服务器异常！")
    ;

    HttpStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
