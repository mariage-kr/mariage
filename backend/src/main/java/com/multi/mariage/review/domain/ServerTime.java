package com.multi.mariage.review.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ServerTime {
    public static LocalDateTime getDate() {
        return LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static LocalDateTime getDateHour() {
        return LocalDateTime.now().withMinute(0).withSecond(0).withNano(0);
    }

}
