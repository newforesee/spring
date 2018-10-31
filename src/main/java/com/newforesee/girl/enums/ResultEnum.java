package com.newforesee.girl.enums;

/**
 * Created by newforesee on 2018/8/8.
 */
public enum ResultEnum {
    UNKNOW_ERREO(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"小学生"),
    MIDDLE_SCHOOL(101,"中学生"),
    USER_HAS_EXIST(40,"用户已存在"),
    USER_NOT_EXIST(41,"用户名不存在"),
    PASSWD_WRONG(44,"密码错误"),
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
