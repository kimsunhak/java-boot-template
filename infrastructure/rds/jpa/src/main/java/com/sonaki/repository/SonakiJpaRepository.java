package com.sonaki.repository;

import com.sonaki.entity.SonakiEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SonakiJpaRepository extends JpaRepository<SonakiEntity, Long> {
    Optional<SonakiEntity> findByOriginalName(String originalName);
}
