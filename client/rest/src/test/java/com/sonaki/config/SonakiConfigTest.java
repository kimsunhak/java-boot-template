package com.sonaki.config;

import com.sonaki.internal.repository.SonakiRepository;
import com.sonaki.internal.service.SonakiService;
import com.sonaki.repository.SonakiJpaRepository;
import com.sonaki.repository.SonakiRepositoryImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class SonakiConfigTest {
    @Bean
    public SonakiRepository sonakiRepository(SonakiJpaRepository sonakiJpaRepository) {
        return new SonakiRepositoryImpl(sonakiJpaRepository);
    }

    @Bean
    public SonakiService sonakiService(SonakiRepository sonakiRepository) {
        return new SonakiService(sonakiRepository);
    }
}
