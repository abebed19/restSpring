package com.abayllc.restchapetex.rest;

public class StudentErrorResponse {
    private int status;
    private String messsage;
    private  long timestamp;

    public StudentErrorResponse() {

    }

    public StudentErrorResponse(int status, String messsage, long timestamp) {
        this.status = status;
        this.messsage = messsage;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
