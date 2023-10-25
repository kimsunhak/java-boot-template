package com.sonaki.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Sonaki {
    private String originName;

    public Sonaki(String originName) {
        this.originName = originName;
    }
}
