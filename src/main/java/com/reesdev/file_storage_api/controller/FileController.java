package com.reesdev.file_storage_api.controller;

import com.reesdev.file_storage_api.service.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.reesdev.file_storage_api.dto.FileResponse;
import java.util.List;


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
    @GetMapping
    public List<FileResponse> getAllFiles() {
        return fileService.getAllFiles();
    }
    @GetMapping("/my-files")
    public List<FileResponse> getMyFiles() {
        return fileService.getMyFiles();
    }
}
