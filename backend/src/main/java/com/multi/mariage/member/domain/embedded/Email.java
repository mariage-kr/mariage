package com.multi.mariage.member.domain.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {

    @Column(name = "email")
    private String value;

}
