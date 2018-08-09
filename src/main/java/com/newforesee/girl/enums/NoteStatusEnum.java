package com.newforesee.girl.enums;

/**
 * Created by newforesee on 2018/8/9.
 */
public enum NoteStatusEnum {
    ADD(0,"添加笔记"),
    DORP(1,"放入回收站"),
    DELETE(-1,"彻底删除")
    ;

    private Integer code;
    private String  status;

    NoteStatusEnum(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
