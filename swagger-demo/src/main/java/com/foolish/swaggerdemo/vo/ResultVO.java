package com.foolish.swaggerdemo.vo;

import lombok.Data;

/**
 * @Description: http请求最外层对象
 * @Author DaiYang
 * @Date 2019/1/7 13:50
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;


}
