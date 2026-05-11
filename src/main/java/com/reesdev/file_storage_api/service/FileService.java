package com.reesdev.file_storage_api.service;
import com.reesdev.file_storage_api.dto.FileResponse;

import com.reesdev.file_storage_api.entity.FileData;
import com.reesdev.file_storage_api.repository.FileRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {

    private final String uploadDir = "uploads";

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public String uploadFile(MultipartFile file) throws IOException {

        String originalFileName = file.getOriginalFilename();

        String extension = "";

        if (originalFileName != null &&
                originalFileName.contains(".")) {

            extension = originalFileName.substring(
                    originalFileName.lastIndexOf(".")
            );
        }

        String storedFileName =
                UUID.randomUUID() + extension;

        Path path = Paths.get(uploadDir, storedFileName);

        Files.createDirectories(path.getParent());

        Files.write(path, file.getBytes());

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        FileData fileData = new FileData();

        fileData.setOriginalFileName(originalFileName);
        fileData.setStoredFileName(storedFileName);
        fileData.setFilePath(path.toString());
        fileData.setFileSize(file.getSize());
        fileData.setUploadedAt(LocalDateTime.now());
        fileData.setUploadedBy(email);

        fileRepository.save(fileData);

        return storedFileName;
    }
    public List<FileResponse> getAllFiles() {

        return fileRepository.findAll()
                .stream()
                .map(file -> new FileResponse(
                        file.getId(),
                        file.getOriginalFileName(),
                        file.getStoredFileName(),
                        file.getFileSize(),
                        file.getUploadedAt(),
                        file.getUploadedBy()
                ))
                .toList();
    }
}