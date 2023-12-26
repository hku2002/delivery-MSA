package com.delivery.store.api.service;

import com.delivery.store.api.domain.entity.Menu;
import com.delivery.store.api.domain.entity.Option;
import com.delivery.store.api.domain.entity.Store;
import com.delivery.store.api.domain.repository.MenuRepository;
import com.delivery.store.api.domain.repository.OptionRepository;
import com.delivery.store.api.domain.repository.StoreRepository;
import com.delivery.store.api.dto.AddMenuRequestDto;
import com.delivery.store.api.dto.AddMenuResponseDto;
import com.delivery.store.api.dto.AddOptionRequestDto;
import com.delivery.store.api.dto.AddOptionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuService {

    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;
    private final OptionRepository optionRepository;

    @Transactional
    public AddMenuResponseDto addMenu(AddMenuRequestDto requestDto) {
        Store store = storeRepository.findById(requestDto.storeId()).orElseThrow();
        Menu menu = menuRepository.save(Menu.of(requestDto, store));
        return new AddMenuResponseDto(menu.getId());
    }

    @Transactional
    public AddOptionResponseDto addOption(AddOptionRequestDto requestDto) {
        Menu menu = menuRepository.findById(requestDto.menuId()).orElseThrow();
        Option option = optionRepository.save(Option.of(requestDto, menu));
        return new AddOptionResponseDto(option.getId());
    }

}
