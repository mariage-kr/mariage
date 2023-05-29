package com.multi.mariage.category.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class StorageRemoveRequest {
    private Long id;

    public StorageRemoveRequest(Long id) {
        this.id = id;
    }
}
