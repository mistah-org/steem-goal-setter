package org.mistah.steemgoalsetter.web;

import org.springframework.web.multipart.MultipartFile;

public class CsvFileUploadForm {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
