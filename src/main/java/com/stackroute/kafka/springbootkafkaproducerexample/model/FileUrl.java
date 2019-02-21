package com.stackroute.kafka.springbootkafkaproducerexample.model;

public class FileUrl {
    private String fileUrl;

    public FileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public FileUrl() {
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
