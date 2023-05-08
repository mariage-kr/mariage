package com.multi.mariage.category.controller;

import com.multi.mariage.auth.controller.AuthController;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.dto.DrinkUpperCategoriesResponse;
import com.multi.mariage.category.dto.DrinkUpperCategoryResponse;
import com.multi.mariage.category.dto.DrinkUpperCategoryValuesResponse;
import com.multi.mariage.category.service.DrinkUpperCategoryService;
import com.multi.mariage.common.annotation.ControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

class CategoryControllerTest extends ControllerTest {
    AutoCloseable openMocks;
    protected MediaType contentType =
            new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(CategoryController.class).build();
    }

    @DisplayName("상위 카테고리 조회 테스트")
    @Test
    void 상위_카테고리_조회() throws Exception {
        DrinkUpperCategoryResponse response = Mockito.mock(DrinkUpperCategoryResponse.class);
        Mockito.when(drinkUpperCategoryService.findCategories()).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/categories/upper"))
//                .contentType(MediaType.APPLICATION_JSON) //보내는 데이터의 타입을 명시
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(document("categoryList",
                                preprocessResponse(prettyPrint())
                        )
                );

    }

}