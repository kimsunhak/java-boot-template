package com.sonaki.mapper;

import com.sonaki.entity.SonakiEntity;
import com.sonaki.model.Sonaki;

public class SonakiMapper {

    public static SonakiEntity toEntity(
            Sonaki sonaki
    ) {
        return SonakiEntity.builder()
                .originalName(sonaki.getOriginName())
                .build();
    }

    public static Sonaki toDomain(
            SonakiEntity sonakiEntity
    ) {
        return new Sonaki(sonakiEntity.getOriginalName());
    }
}
