package com.reesdev.file_storage_api.repository;

import com.reesdev.file_storage_api.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileData, Long> {
    List<FileData> findByUploadedBy(String uploadedBy);
}