package com.reesdev.file_storage_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "files")
@Getter
@Setter
@NoArgsConstructor
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalFileName;
    private String storedFileName;
    private String filePath;
    private Long fileSize;
    private LocalDateTime uploadedAt;
    private String uploadedBy;
}
