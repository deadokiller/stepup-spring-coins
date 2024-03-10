package ru.vtb.javapro.homework.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.vtb.javapro.homework.model.ErrorDto;


@RestControllerAdvice(assignableTypes = {
        ProductController.class
})
public class RestExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class.getName());

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorDto handleThrowable(Throwable t) {
        log.error("Internal error:", t);
        var message = "%s: %s".formatted(t.getClass().getName(), t.getMessage());
        return new ErrorDto("INTERNAL_ERROR_CODE", message);
    }
}
