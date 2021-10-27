package com.xiaozhen.mall.tiny.common.api;

/**
 * @description : 通用返回对象
 * @create time:2021/10/16
 * @Author :XiaoZhen
 **/
public class CommontResult<T> {
    private Long code;
    private String message;
    private T data;

    public CommontResult() {
    }

    public CommontResult(Long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommontResult<T> success(T data) {
        return new CommontResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> CommontResult<T> success(T data, String message) {
        return new CommontResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> CommontResult<T> failed(IErrorCode errorCode) {
        return new CommontResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> CommontResult<T> failed(String message) {
        return new CommontResult<>(ResultCode.FAILED.getCode(), message, null);
    }

    public static <T> CommontResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    public static <T> CommontResult<T> vaildateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    public static <T> CommontResult<T> vaildateFailed(String message) {
        return new CommontResult<>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    public static <T> CommontResult<T> unauthorized(T data) {
        return new CommontResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    public static <T> CommontResult<T> forbidden(T data) {
        return new CommontResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
