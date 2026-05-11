package com.reesdev.file_storage_api.repository;

import com.reesdev.file_storage_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
