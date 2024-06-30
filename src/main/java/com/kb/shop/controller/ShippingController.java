package com.kb.shop.controller;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.dto.ShippingInfoDto;
import com.kb.shop.service.ShippingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/shipping")
public class ShippingController {

    private final ShippingService shippingService;

    // 배송 정보를 확인하는 GET 호출을 생성합니다.  (path : /shipping)
    @GetMapping("/{id}")
    public ShippingInfoDto getShippingInfo(@PathVariable Long id) {
        log.info("GET /shipping/{}", id);
        return shippingService.getShippingInfo(id);
    }

    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
    @PostMapping("/")
    public ShippingInfoDto createShippingInfo(
            @Valid @RequestBody ShippingInfo request
    ) {
        // POST /shipping HTTP/1.1
        log.info("request: {}", request);

        return shippingService.createShippingInfo(request);
    }

    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping)
    @PutMapping("/{id}")
    public ShippingInfoDto editShippingInfo(
            @PathVariable Long id, @Valid @RequestBody ShippingInfo request
    ) {
        // GET /developers HTTP/1.1
        log.info("PUT /shipping/{} HTTP/1.1", id);

        return shippingService.editShippingInfo(id, request);
    }
}
