package com.newforesee.girl.enums;

/**
 * Created by newforesee on 2018/8/8.
 */
public enum ResultEnum {
    UNKNOW_ERREO(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"小学生"),
    MIDDLE_SCHOOL(101,"中学生"),
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
