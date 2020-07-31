package com.example.todo.api.controller;

import com.example.todo.api.controller.exception.ButResponseException;
import com.example.todo.api.controller.resourses.response.ToResponse;
import com.example.todo.api.infrastructure.repository.entity.TodoEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
public class TodoControllerAdvice extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    /**
     * リクエストボディに設定された値に対する入力値チェック時に、エラーが発生した場合のハンドリングを実施します。
     * レスポンスボディには、{@link BindingResult}から取得したフィールド名と、メッセージをを出力します。
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(
                ex,
                body(ex.getBindingResult()),
                headers,
                status,
                request);
    }

    /**
     * クエリパラメータに対する入力値チェック時に、エラーが発生した場合のハンドリングを実施します。
     * レスポンスボディには、{@link BindingResult}から取得したフィールド名と、メッセージをを出力します。
     */
    @Override
    protected ResponseEntity<Object> handleBindException(
            BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(
                ex,
                body(ex.getBindingResult()),
                headers,
                status,
                request);
    }

    private List<ApiError> body(BindingResult bindingResult) {
        return bindingResult
                .getFieldErrors()
                .stream()
                .map(fieldError ->
                        new ApiError(
                                fieldError.getField(),
                                messageSource.getMessage(fieldError, LocaleContextHolder.getLocale())
                        )
                )
                .collect(Collectors.toList());
    }


    static class ApiError implements Serializable {

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private final String field;
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private final String message;

        ApiError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }

    @ExceptionHandler({ButResponseException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ToResponse ButResponse(Exception e, WebRequest req) {
        return new ToResponse("But Request");
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ToResponse handleMyException(Exception e, WebRequest req) {
        return new ToResponse("internal server error");
    }
}

