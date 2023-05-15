package com.multi.mariage.common.annotation;

import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.member.service.MemberModifyService;
import com.multi.mariage.product.service.ProductFindService;
import com.multi.mariage.product.service.ProductModifyService;
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
    protected MemberModifyService memberModifyService;

    @Autowired
    protected MemberFindService memberFindService;
    @Autowired
    protected ProductFindService productFindService;
    @Autowired
    protected ProductModifyService productModifyService;
    @Autowired
    protected StorageRepository storageRepository;
}
