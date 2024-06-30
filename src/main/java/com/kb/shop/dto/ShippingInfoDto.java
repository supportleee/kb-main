package com.kb.shop.dto;

import com.kb.shop.domain.Order;
import com.kb.shop.domain.OrderItem;
import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.domain.enums.ShippingStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShippingInfoDto {
    private Order order;
    private OrderItem orderItem;
    private ShippingStatus shippingStatus;

    public static ShippingInfoDto fromEntity(ShippingInfo shippingInfo){
        return ShippingInfoDto.builder()
                .order(shippingInfo.getOrder())
                .orderItem(shippingInfo.getOrderItem())
                .shippingStatus(shippingInfo.getStatus())
                .build();

    }
}
