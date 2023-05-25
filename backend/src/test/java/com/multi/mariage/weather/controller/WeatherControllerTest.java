package com.multi.mariage.weather.controller;

import com.multi.mariage.common.annotation.ControllerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class WeatherControllerTest extends ControllerTest {

    @DisplayName("현재 날씨 정보를 조회한다.")
    @Test
    void 현재_날씨_정보를_조회한다() throws Exception {
        mockMvc.perform(get("/api/weather/info"))
                .andDo(print())
                .andDo(document("Weather/Info",
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("weather").description("날씨 데이터"),
                                fieldWithPath("name").description("날씨 정보"),
                                fieldWithPath("temp").description("날씨 온도")
                        )))
                .andExpect(status().isOk());
    }
}