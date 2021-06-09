package com.example.ApplicationFiles;
public class UploadResponse {

    private String fileName;
    private String algorithm;
    private String fileHash;

    public UploadResponse(String fileName, String algorithm, String fileHash) {
        this.fileName = fileName;
        this.algorithm = algorithm;
        this.fileHash = fileHash;
    }
    public String getFileName() {
        return this.fileName;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }
    public String getFileHash() {
        return this.fileHash;
    }

}