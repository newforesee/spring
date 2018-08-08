package com.newforesee.girl.exception;

import com.newforesee.girl.enums.ResultEnum;

/**
 * Created by newforesee on 2018/8/8.
 */
public class GirlException  extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
