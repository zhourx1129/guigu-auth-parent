package com.zhourx.system.exception;

import com.zhourx.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail().message("执行了全局异常处理");
    }

    // 指定特定异常处理器
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result error(MyException myException){
        myException.printStackTrace();
        return Result.fail().code(myException.getCode()).message(myException.getMsg());
    }
}
