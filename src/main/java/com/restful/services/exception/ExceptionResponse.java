package com.restful.services.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timeStamp;
    private String name;
    private String details;

    public ExceptionResponse(Date timeStamp, String name, String details) {
        this.timeStamp = timeStamp;
        this.name = name;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }


}
