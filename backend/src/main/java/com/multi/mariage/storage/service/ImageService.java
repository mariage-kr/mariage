package com.multi.mariage.storage.service;

import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.exception.StorageErrorCode;
import com.multi.mariage.storage.exception.StorageException;
import com.multi.mariage.storage.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ImageService {

    private final StorageRepository storageRepository;
    @Value("${storagePath}")
    private String was;

    public Image findById(Long imageId) {
        return storageRepository.findById(imageId)
                .orElseThrow(() -> new StorageException(StorageErrorCode.FAILED_TO_FIND_IMAGE));
    }

    public String getImageUrl(String fileName) {
        return was + fileName;
    }
}
