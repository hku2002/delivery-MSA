package com.example.mvcstoredisplay.service;

import com.example.mvcstoredisplay.domain.repository.DisplayStoreRepository;
import com.example.mvcstoredisplay.dto.DisplayStoreResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisplayService {

    private final DisplayStoreRepository displayStoreRepository;

    public List<DisplayStoreResponseDto> getStores() {
        return DisplayStoreResponseDto.createInstance(displayStoreRepository.findAll());
    }

}
