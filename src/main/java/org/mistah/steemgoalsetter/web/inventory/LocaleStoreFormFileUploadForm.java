package org.mistah.steemgoalsetter.web.inventory;

import org.springframework.web.multipart.MultipartFile;

public class LocaleStoreFormFileUploadForm {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
