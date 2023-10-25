package com.sonaki.usecase;

import com.sonaki.internal.service.SonakiService;
import com.sonaki.model.Sonaki;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SonakiUseCase {
    private final SonakiService sonakiService;

    @Transactional
    public String create(String originName) {
        Sonaki sonaki = sonakiService.create(originName);
        return sonaki.getOriginName();
    }

    @Transactional(readOnly = true)
    public String find(String originName) {
        Sonaki sonaki = sonakiService.find(originName);
        return sonaki.getOriginName();
    }

}
