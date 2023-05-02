package com.multi.mariage.auth.domain;

import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<RefreshToken, Long> {
}
