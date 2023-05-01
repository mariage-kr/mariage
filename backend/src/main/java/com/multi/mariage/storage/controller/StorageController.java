package com.multi.mariage.storage.controller;

import com.multi.mariage.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/api/images/auth")
@RequiredArgsConstructor
@RestController
public class StorageController {

    private final StorageService storageService;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestParam MultipartFile file) throws IOException {
        storageService.save(file);
        return ResponseEntity.ok().build();
    }
}
