package com.school.administration.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpResponseMessage implements Serializable {

    private boolean success;
    private String error;
    private ResponseData responseData ;
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long timeout;

    public HttpResponseMessage() {
    }

    public HttpResponseMessage(HttpResponseMessageBuilder httpResponseMessageBuilder) {
        this.success               = httpResponseMessageBuilder.success;
        this.error                 = httpResponseMessageBuilder.error;
        this.responseData          = new ResponseData( httpResponseMessageBuilder.item , httpResponseMessageBuilder.items );
        this.msg                   = httpResponseMessageBuilder.msg;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class HttpResponseMessageBuilder{

        private boolean success;
        private String error;
        private Object item;
        private List<?> items;
        private String msg;

        public HttpResponseMessageBuilder success(boolean success){
            this.success = success;
            return this;
        }

        public HttpResponseMessageBuilder error(String error){
            this.error = error;
            return this;
        }

        public HttpResponseMessageBuilder item(Object item){
            this.item = item;
            return this;
        }

        public HttpResponseMessageBuilder items(List<?> items){
            this.items = items;
            return this;
        }

        public HttpResponseMessageBuilder msg(String msg){
            this.msg = msg;
            return this;
        }

        public HttpResponseMessage build(){
            return new HttpResponseMessage(this);
        }

    }
}

