package com.newforesee.girl.handle;

import com.newforesee.girl.daomain.Result;
import com.newforesee.girl.exception.GirlException;
import com.newforesee.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by newforesee on 2018/8/7.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            Result result = ResultUtil.error(girlException.getCode(), girlException.getMessage());
            logger.warn("【异常返回信息】:"+result.toString());
            return result;
        } else {
            logger.error("【系统异常】:",e);
            return ResultUtil.error(-1, "未知错误");
        }

    }

}
