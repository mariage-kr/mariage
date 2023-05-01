package com.multi.mariage.storage.controller;

import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.dto.response.ImageSavedResponse;
import com.multi.mariage.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/images/auth")
@RequiredArgsConstructor
@RestController
public class StorageController {

    private final StorageService storageService;

    @PostMapping("/save")
    public ResponseEntity<ImageSavedResponse> save(@RequestParam MultipartFile file) {
        Image savedImage = storageService.save(file);
        ImageSavedResponse response = ImageSavedResponse.from(savedImage);
        return ResponseEntity.ok(response);
    }
}
