package com.kakaobank.blog.common.exception;

import lombok.Getter;

@Getter
public class BlogRuntimeException extends RuntimeException {
    private String code = "9999";

    public BlogRuntimeException(String errCode, String message) {
        super(message);
        this.code = errCode;
    }

}
