package com.zhourx.system.exception;

import lombok.Data;

@Data
public class MyException {
    private Integer code;
    private String msg;
}
