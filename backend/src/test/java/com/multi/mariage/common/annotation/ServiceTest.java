package com.multi.mariage.common.annotation;

import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.member.service.MemberModifyService;
import com.multi.mariage.product.service.ProductService;
import com.multi.mariage.storage.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public abstract class ServiceTest {
    @Autowired
    protected StorageRepository storageRepository;
    @Autowired
    protected ProductService productService;
    @Autowired
    protected MemberModifyService memberModifyService;

    @Autowired
    protected MemberFindService memberFindService;
}
