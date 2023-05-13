package com.multi.mariage.storage.controller;

import com.multi.mariage.storage.dto.response.ImageSavedResponse;
import com.multi.mariage.storage.service.StorageService;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class StorageController {

    private final StorageService storageService;

    @PostMapping("/user/storage/image")
    public ResponseEntity<ImageSavedResponse> upload(@RequestParam MultipartFile file) {
        ImageSavedResponse response = storageService.upload(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/user/storage/image")
    public ResponseEntity<Void> remove(@Param("imageId") Long imageId) {
        storageService.removeByImageId(imageId);
        return ResponseEntity.ok().build();
    }
}
