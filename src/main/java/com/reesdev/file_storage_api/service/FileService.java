package com.reesdev.file_storage_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final String uploadDir = "uploads";

    public String uploadFile(MultipartFile file) throws IOException {

        String filename = file.getOriginalFilename();

        Path path = Paths.get(uploadDir, filename);

        Files.createDirectories(path.getParent());

        Files.write(path, file.getBytes());

        return filename;
    }
}