package com.multi.mariage.storage.service;

import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StorageService {

    private final StorageRepository storageRepository;

    @Value("${fileDir}")
    private String fileDir;

    @Transactional
    public Image save(MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = Objects.requireNonNull(originalFileName)
                .substring(originalFileName.lastIndexOf("."));
        String savedFileName = uuid + extension;
        Image image = new Image(savedFileName);

        file.transferTo(new File(fileDir + savedFileName));
        return storageRepository.save(image);
    }
}
