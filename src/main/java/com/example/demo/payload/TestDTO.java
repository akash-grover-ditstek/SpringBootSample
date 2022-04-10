package com.example.demo.payload;

import org.springframework.web.multipart.MultipartFile;

public class TestDTO {
    private MultipartFile file;


    public MultipartFile getFile() {
        return this.file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


    public TestDTO(MultipartFile file) {
        this.file = file;
    }


    public TestDTO() {
    }
    
}
