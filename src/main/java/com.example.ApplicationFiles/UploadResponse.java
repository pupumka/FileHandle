package com.example.ApplicationFiles;
public class UploadResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public UploadResponse(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }
    public String getFileName() {
        return this.fileName;
    }
    public String getFileDownloadUri() {
        return this.fileDownloadUri;
    }
    public String getFileType() {
        return this.fileType;
    }
    public long getSize() {
        return this.size;
    }

}