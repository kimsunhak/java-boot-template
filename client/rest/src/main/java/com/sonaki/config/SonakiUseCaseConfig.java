package com.sonaki.config;

import com.sonaki.internal.repository.SonakiRepository;
import com.sonaki.internal.service.SonakiService;
import com.sonaki.repository.SonakiJpaRepository;
import com.sonaki.repository.SonakiRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SonakiUseCaseConfig {

    @Bean
    public SonakiRepository sonakiRepository(SonakiJpaRepository sonakiJpaRepository) {
        return new SonakiRepositoryImpl(sonakiJpaRepository);
    }

    @Bean
    public SonakiService sonakiService(SonakiRepository sonakiRepository) {
        return new SonakiService(sonakiRepository);
    }
}
