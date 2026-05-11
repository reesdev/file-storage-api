package com.reesdev.file_storage_api.controller;

import com.reesdev.file_storage_api.service.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public String uploadFile(
            @RequestParam("file") MultipartFile file
    ) throws Exception {

        String uploadedFile = fileService.uploadFile(file);

        return "File uploaded: " + uploadedFile;
    }
}
