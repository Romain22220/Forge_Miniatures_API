package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.ShopDTO;
import com.forge_miniatures.entity.Shop;

public class ShopMapper {



    public static ShopDTO toShopDTO(Shop shop) {
        if(shop == null) return null;
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setId(shop.getId());
        UserMapper.userDTO(shop.getUser());

        return shopDTO;
    }

    public static Shop toShop(ShopDTO shopDTO) {
        if(shopDTO == null) return null;

        Shop shop = new Shop();
        shop.setId(shopDTO.getId());
        UserMapper.userDTO(shop.getUser());
        return shop;
    }
}
