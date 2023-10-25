package com.sonaki.controller;

import com.sonaki.dto.SonakiRequestDto;
import com.sonaki.dto.util.ApiResponse;
import com.sonaki.usecase.SonakiUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sonaki")
@RequiredArgsConstructor
public class SonakiController {

    private final SonakiUseCase sonakiUseCase;

    @PostMapping
    public ApiResponse<String> create(
            @RequestBody SonakiRequestDto sonakiRequestDto
    ) {
        if (!StringUtils.hasText(sonakiRequestDto.getOriginName())) {
            throw new IllegalArgumentException("originName required");
        }
        return ApiResponse.ok(sonakiUseCase.create(sonakiRequestDto.getOriginName()));
    }

    @GetMapping
    public ApiResponse<String> get(
            @RequestParam(name = "originName", required = false) String originName
    ) {
        if (!StringUtils.hasText(originName)) {
            throw new IllegalArgumentException("originName required");
        }
        return ApiResponse.ok(sonakiUseCase.find(originName));
    }
}
