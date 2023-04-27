package com.multi.mariage.member.domain.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Nickname {
    @Column(name = "nickname", nullable = false)
    private String value;
}
