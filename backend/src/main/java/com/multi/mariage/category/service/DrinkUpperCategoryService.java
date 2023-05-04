package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.dto.DrinkUpperCategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class DrinkUpperCategoryService {
    public List<DrinkUpperCategory> findAll() {
        return Arrays.asList(DrinkUpperCategory.values());
    }
    @Transactional
    public List<DrinkUpperCategoryResponse> findCategoriesByOrigin(String origin) {
        List<DrinkUpperCategory> categories = findAll();
        List<DrinkUpperCategoryResponse> responseList = new ArrayList<>();

        List<String> categoryList = categories.stream()
                .filter(c -> c.getOrigin().equals(origin))
                .map(DrinkUpperCategory::getName)
                .collect(Collectors.toList());

        DrinkUpperCategoryResponse response = new DrinkUpperCategoryResponse();
        response.setCategory(categoryList);
        responseList.add(response);

        return responseList;
    }

}
