package com.kakaobank.blog.common.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@RequiredArgsConstructor
public class BlogExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({BlogRuntimeException.class})
    public ResponseEntity<StatusMsg> blogExceptionHandler(HttpServletRequest request, HttpServletResponse respone, final BlogRuntimeException e) {
        e.printStackTrace();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) //400
                .body(StatusMsg.builder()
                        .errorCode(e.getCode())
                        .errorMsg(e.getMessage())
                        .build());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    public ResponseEntity<StatusMsg> blogExceptionHandler(HttpServletRequest request, HttpServletResponse respone, final Exception e) {
        e.printStackTrace();

        return ResponseEntity
                .status(500)
                .body(StatusMsg.builder()
                        .errorCode(StatusEnum.UNKNOWN_ERROR.getCode())
                        .errorMsg(StatusEnum.UNKNOWN_ERROR.getMessage())
                        .build());
    }

}
