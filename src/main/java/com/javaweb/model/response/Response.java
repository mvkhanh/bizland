package com.javaweb.model.response;

import lombok.Getter;

@Getter
public class Response {
    private final Object data;
    private final String message;
    private final String detail;

    public Response(RequestBuilder builder){
        this.data = builder.data;
        this.message = builder.message;
        this.detail = builder.detail;
    }

    public static class RequestBuilder{
        private Object data;
        private  String message;
        private  String detail;

        public RequestBuilder data(Object data){
            this.data = data;
            return this;
        }
        public RequestBuilder message(String message){
            this.message = message;
            return this;
        }
        public RequestBuilder detail(String detail){
            this.detail = detail;
            return this;
        }

        public Response build(){
            return new Response(this);
        }
    }
}
