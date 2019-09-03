package com.wan.scloud.service.bean;


import lombok.Getter;

public class ResponseBean {

    // response code
    private static final String SUCCESS = "SUCCESS";
    private static final String ERROR = "ERROR";
    public static final String REQUEST_RESET = "REQUEST_RESET";

    @Getter
    private String code;

    @Getter
    private String message;

    @Getter
    private Object data;

    @Getter
    private Object extra;

    /**
     * success表示成功返回预期结果.
     */
    public static ResponseBean success() {
        return new ResponseBean().setCode(SUCCESS).setMessage("OK");
    }

    public static ResponseBean error() {
        return new ResponseBean().setCode(ERROR).setMessage("Internal Server Error");
    }

    public static ResponseBean success(final Object data) {
        return success().setData(data);
    }

    public static ResponseBean error(final String code, final String message) {
        return new ResponseBean().setCode(code).setMessage(message);
    }

    private ResponseBean setCode(final String code) {
        this.code = code;
        return this;
    }

    private ResponseBean setMessage(final String message) {
        this.message = message;
        return this;
    }

    public ResponseBean setExtra(final Object extra) {
        if (extra instanceof CharSequence) {
            this.extra = extra.toString();
        }
        return this;
    }

    private ResponseBean setData(final Object data) {
        this.data = data;
        return this;
    }

}
