package com.delivery.store.api.service;

import com.delivery.store.api.domain.entity.Menu;
import com.delivery.store.api.domain.entity.Option;
import com.delivery.store.api.domain.entity.Outbox;
import com.delivery.store.api.domain.entity.Store;
import com.delivery.store.api.domain.enumtype.Action;
import com.delivery.store.api.domain.enumtype.Operation;
import com.delivery.store.api.domain.enumtype.OutboxStatus;
import com.delivery.store.api.domain.repository.MenuRepository;
import com.delivery.store.api.domain.repository.OptionRepository;
import com.delivery.store.api.domain.repository.OutboxRepository;
import com.delivery.store.api.domain.repository.StoreRepository;
import com.delivery.store.api.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuService {

    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;
    private final OptionRepository optionRepository;
    private final OutboxRepository outboxRepository;

    @Transactional
    public AddMenuResponseDto addMenu(AddMenuRequestDto requestDto) {
        Store store = storeRepository.findById(requestDto.storeId()).orElseThrow();
        Menu menu = menuRepository.save(Menu.of(requestDto, store));
        Outbox outbox = Outbox.of(menu, Action.CREATE_MENU, Operation.CREATE, OutboxStatus.CDC);
        outboxRepository.save(outbox);
        return new AddMenuResponseDto(menu.getId());
    }

    @Transactional
    public AddOptionResponseDto addOption(AddOptionRequestDto requestDto) {
        Menu menu = menuRepository.findById(requestDto.menuId()).orElseThrow();
        Option option = optionRepository.save(Option.of(requestDto, menu));
        Outbox outbox = Outbox.of(option, Action.CREATE_MENU, Operation.CREATE, OutboxStatus.CDC);
        outboxRepository.save(outbox);
        return new AddOptionResponseDto(option.getId());
    }

    public List<GetMenuResponseDto> getMenu(GetMenuRequestDto requestDto) {
        Store store = storeRepository.findById(requestDto.storeId()).orElseThrow();
        List<Menu> menus = menuRepository.findAllByStore(store);
        return GetMenuResponseDto.from(menus);
    }

}
