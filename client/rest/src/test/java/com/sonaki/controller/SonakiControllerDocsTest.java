package com.sonaki.controller;

import static com.sonaki.RestDocsUtils.requestPreprocessor;
import static com.sonaki.RestDocsUtils.responsePreprocessor;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sonaki.SpringRestDocsTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonaki.dto.SonakiRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;

@SpringRestDocsTest
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "sonaki.com", uriPort = 443)
public class SonakiControllerDocsTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("[Create]")
    @Test
    void create() throws Exception {
        // given
        SonakiRequestDto sonakiRequestDto = new SonakiRequestDto("소나기");

        // when
        String json = objectMapper.writeValueAsString(sonakiRequestDto);

        // then
        mockMvc.perform(
                        post("/v1/sonaki")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andExpect(status().isOk())
                .andDo(document(
                        "create",
                        requestPreprocessor(),
                        responsePreprocessor(),
                        requestFields(
                                fieldWithPath("originName")
                                        .type(JsonFieldType.STRING)
                                        .description("원본 이름")
                        ),
                        responseFields(
                                fieldWithPath("result")
                                        .type(JsonFieldType.STRING)
                                        .description("결과 처리 상태"),
                                fieldWithPath("data")
                                        .type(JsonFieldType.STRING)
                                        .description("처리 결과")
                        )
                ));
    }

    @DisplayName("[Find]")
    @Test
    void find() throws Exception {
        // given
        String originName = "소나기";

        // then
        mockMvc.perform(
                        get("/v1/sonaki")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("originName",originName)
                )
                .andExpect(status().isOk())
                .andDo(document(
                        "find",
                        requestPreprocessor(),
                        responsePreprocessor(),
                        requestParameters(
                         parameterWithName("originName").description("원본 이름")
                        ),
                        responseFields(
                                fieldWithPath("result")
                                        .type(JsonFieldType.STRING)
                                        .description("결과 처리 상태"),
                                fieldWithPath("data")
                                        .type(JsonFieldType.STRING)
                                        .description("처리 결과")
                        )
                ));
    }
}
