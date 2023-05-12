package com.multi.mariage.storage.service;

import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.exception.StorageErrorCode;
import com.multi.mariage.storage.exception.StorageException;
import com.multi.mariage.storage.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ImageService {
    private final StorageRepository storageRepository;
    public Image findById(ProductSaveRequest request) {
        return storageRepository.findById(request.getImageId())
                .orElseThrow(() -> new StorageException(StorageErrorCode.FAILED_TO_FIND_IMAGE));
    }
}
