package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.ContainDTO;
import com.forge_miniatures.dto.ContainIdDTO;
import com.forge_miniatures.entity.Article;
import com.forge_miniatures.entity.Contain;
import com.forge_miniatures.entity.ContainId;
import com.forge_miniatures.entity.Shop;

public class ContainMapper {

    public static ContainDTO containDTO(Contain contain) {
        if(contain == null) return null;
        ContainDTO containDTO = new ContainDTO();

        ContainIdDTO  containIdDTO = new ContainIdDTO();
        containIdDTO.setIdtArticle(contain.getArticle().getId());
        containIdDTO.setIdtPanier(contain.getId().getIdtPanier());

        containDTO.setId(containIdDTO);
        containDTO.setQuantity(contain.getQuantity());

        if(contain.getArticle() != null)
        {
            containDTO.setArticle(contain.getArticle().getNom());
        }

        if(contain.getShop() != null)
            containDTO.setShop(contain.getShop().getUser().getPseudo());

        return containDTO;
    }

    public static Contain contain(ContainDTO containDTO, Article article, Shop shop) {
        if (containDTO == null) return null;

        Contain contain = new Contain();
        contain.setId(new ContainId(containDTO.getId().getIdtPanier(), containDTO.getId().getIdtArticle()));
        contain.setQuantity(containDTO.getQuantity());
        contain.setArticle(article);
        contain.setShop(shop);
        return contain;

    }
}
