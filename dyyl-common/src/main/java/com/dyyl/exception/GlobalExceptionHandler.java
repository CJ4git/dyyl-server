package com.dyyl.exception;

import com.dyyl.dto.sys.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author cj
 * @Description
 * @Date 2023/11/17
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response<?> exception(Exception e) {
        return Response.error(e.getMessage());
    }
}
