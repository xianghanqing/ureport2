package com.example.demo.constant;
import com.example.demo.constant.ResutEnum;
import lombok.Getter;
/**
 * @author hxc
 * @dateTime: 2021-12-4
 * @description: 数据交互响应-提示
 * */
@Getter
public class ResultVo<T> {
    private T data;
    private Integer code;
    private String message;
    public ResultVo(ResutEnum resutEnum) {
        this.code = resutEnum.getCode();
        this.message = resutEnum.getMessage();
        data = null;
    }
    public ResultVo(ResutEnum resutEnum,T data) {
        this.code = resutEnum.getCode();
        this.message = resutEnum.getMessage();
        this.data = data;
    }
    public ResultVo(Integer code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

