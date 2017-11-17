package com.hjc.common.util.http;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class HttpResult implements Serializable {

    private static final long serialVersionUID = 9002896323052896284L;

    @Getter
    @Setter
    private Integer statusCode;

    @Getter
    @Setter
    private String content;

    public HttpResult() {
    }

    public HttpResult(Integer statusCode, String content) {
        this.statusCode = statusCode;
        this.content = content;
    }

    @Override
    public String toString() {
        return "HttpResult [statusCode=" + statusCode + ", content=" + content + "]";
    }
}
