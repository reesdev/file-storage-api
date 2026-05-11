package com.reesdev.file_storage_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class FileResponse {

    private Long id;

    private String originalFileName;

    private String storedFileName;

    private Long fileSize;

    private LocalDateTime uploadedAt;

    private String uploadedBy;
}