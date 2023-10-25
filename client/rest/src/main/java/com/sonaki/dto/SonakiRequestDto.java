package com.sonaki.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SonakiRequestDto {

    private String originName;

    public SonakiRequestDto(String originName) {
        this.originName = originName;
    }
}
