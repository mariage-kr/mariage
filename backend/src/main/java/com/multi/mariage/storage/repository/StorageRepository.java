package com.multi.mariage.storage.repository;


import com.multi.mariage.storage.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Image, Long> {
}
