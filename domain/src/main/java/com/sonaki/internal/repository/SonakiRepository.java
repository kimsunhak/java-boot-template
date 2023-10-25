package com.sonaki.internal.repository;

import com.sonaki.model.Sonaki;

public interface SonakiRepository {

    Sonaki create(String originName);

    Sonaki find(String originName);
}
