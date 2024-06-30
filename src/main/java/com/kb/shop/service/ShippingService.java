package com.kb.shop.service;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.dto.ShippingInfoDto;
import com.kb.shop.repository.ShippingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingService {

    private final ShippingRepository shippingRepository;

    @Transactional
    public ShippingInfoDto createShippingInfo(ShippingInfo shippingInfo){
        shippingRepository.save(shippingInfo);
        return ShippingInfoDto.fromEntity(shippingInfo);
    }

    public ShippingInfoDto getShippingInfo(Long id) {
        return shippingRepository.findById(id)
                .map(ShippingInfoDto::fromEntity)
                .orElseThrow();
    }

    public ShippingInfoDto editShippingInfo(Long id, ShippingInfo request) {
        ShippingInfo shippingInfo = shippingRepository.findById(id).orElseThrow();
        shippingInfo.setStatus(request.getStatus());

        return ShippingInfoDto.fromEntity(shippingInfo);
    }
}
