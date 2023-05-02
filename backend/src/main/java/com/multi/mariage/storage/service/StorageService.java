package com.multi.mariage.storage.service;

import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.dto.response.ImageSavedResponse;
import com.multi.mariage.storage.exception.StorageErrorCode;
import com.multi.mariage.storage.exception.StorageException;
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
    public ImageSavedResponse save(MultipartFile file) {
        String saveFileName = convertFileName(file.getOriginalFilename());
        upload(file, saveFileName);
        Image image = storageRepository.save(new Image(saveFileName));
        return ImageSavedResponse.from(image);
    }

    private String convertFileName(String originFileName) {
        String uuid = UUID.randomUUID().toString();
        String extension = "";
        try {
            extension = Objects.requireNonNull(originFileName)
                    .substring(originFileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new StorageException(StorageErrorCode.FILE_IS_NOT_EXIST);
        }
        return uuid + extension;
    }

    private void upload(MultipartFile file, String saveFileName) {
        try {
            file.transferTo(new File(fileDir + saveFileName));
        } catch (IOException e) {
            throw new StorageException(StorageErrorCode.FILE_UPLOAD_FAILED);
        }
    }
}
