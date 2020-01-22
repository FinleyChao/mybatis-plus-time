package com.foolish.swaggerdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum implements CommonEnum {

    SUCCESS(200,"成功"),
    FAIL(402,"失败"),
    LOGIN_SUCCESS(400,"登录成功"),
    NOT_LOGIN(401,"请先登录"),
    NOT_FOUND(404,"资源不存在"),
    INTERNAL_SERVER_ERROR(500,"服务器内部错误"),
    LOGIN_ERROR(403,"用户名或密码错误"),
    PARAM_ERROR(406,"传入的参数错误"),
    AREA_CODE_ERROR(405,"该用户没有权限登录系统"),

    OBJECT_CONVERT_ERROR(1,"对象转换异常"),

    DIVISOR_IS_ZERO(2,"除数不能为0"),

    ;

    private Integer code;

    private String message;

}
