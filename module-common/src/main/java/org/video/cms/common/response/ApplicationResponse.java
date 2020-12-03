package org.video.cms.common.response;

import lombok.Getter;

/**
 * @author bobo
 * @date 2020/12/3
 */

@Getter
public class ApplicationResponse<T> {
    private final String code;
    private final String message;
    private final T data;

    private ApplicationResponse() {
        throw new UnsupportedOperationException();
    }

    private ApplicationResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApplicationResponse(SystemCodeEnum systemCode, String message, T data) {
        this.code = systemCode.getCode();
        this.message = message;
        this.data = data;
    }

    public ApplicationResponse(SystemCodeEnum systemCode) {
        this.code = systemCode.getCode();
        this.message = systemCode.getDescription();
        this.data = null;
    }

    public static <T> ApplicationResponse<T> succeed() {
        return new ApplicationResponse<>(SystemCodeEnum.SUCCESS.getCode(), SystemCodeEnum.SUCCESS.getDescription(), null);
    }

    public static <T> ApplicationResponse<T> succeed(String message) {
        return new ApplicationResponse<>(SystemCodeEnum.SUCCESS.getCode(), message, null);
    }

    public static <T> ApplicationResponse<T> succeed(String message, T data) {
        return new ApplicationResponse<>(SystemCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> ApplicationResponse<T> fail(SystemCodeEnum systemCode) {
        return new ApplicationResponse<>(systemCode.getCode(), systemCode.getDescription(), null);
    }

    public static <T> ApplicationResponse<T> fail(SystemCodeEnum systemCode, String message) {
        return new ApplicationResponse<>(systemCode.getCode(), message, null);
    }

    public static <T> ApplicationResponse<T> fail(SystemCodeEnum systemCode, String message, T data) {
        return new ApplicationResponse<>(systemCode.getCode(), message, data);
    }

}
