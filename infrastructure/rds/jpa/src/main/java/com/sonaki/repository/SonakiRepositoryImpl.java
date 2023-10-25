package com.sonaki.repository;

import com.sonaki.entity.SonakiEntity;
import com.sonaki.internal.repository.SonakiRepository;
import com.sonaki.mapper.SonakiMapper;
import com.sonaki.model.Sonaki;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class SonakiRepositoryImpl implements SonakiRepository {

    private final SonakiJpaRepository repository;

    @Override
    public Sonaki create(String originName) {
        SonakiEntity sonakiEntity = SonakiEntity.builder()
                .originalName(originName)
                .build();

        return SonakiMapper.toDomain(repository.save(sonakiEntity));
    }

    @Override
    public Sonaki find(String originName) {
        SonakiEntity sonakiEntity = repository.findByOriginalName(originName)
                .orElseThrow(() -> new IllegalStateException(originName + "doesn't exist"));

        return SonakiMapper.toDomain(sonakiEntity);
    }
}
