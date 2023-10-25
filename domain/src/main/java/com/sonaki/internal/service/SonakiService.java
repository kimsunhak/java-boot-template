package com.sonaki.internal.service;

import com.sonaki.internal.repository.SonakiRepository;
import com.sonaki.model.Sonaki;

public class SonakiService {
    private final SonakiRepository repository;

    public SonakiService(SonakiRepository repository) {
        this.repository = repository;
    }

    public Sonaki create(String originName) {
        return repository.create(originName);
    }

    public Sonaki find(String originName) {
        return repository.find(originName);
    }
}
