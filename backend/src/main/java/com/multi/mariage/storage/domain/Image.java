package com.multi.mariage.storage.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "image_name", nullable = false, unique = true)
    private String name;

    public Image(String name) {
        this.name = name;
    }

    public static Image of(String fileName) {
        String uuid = UUID.randomUUID().toString();
        String extension = Objects.requireNonNull(fileName)
                .substring(fileName.lastIndexOf("."));
        String savedFileName = uuid + extension;
        return new Image(savedFileName);
    }
}
