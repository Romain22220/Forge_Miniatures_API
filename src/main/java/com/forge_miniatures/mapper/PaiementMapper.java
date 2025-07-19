package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.PaiementDTO;
import com.forge_miniatures.entity.Paiement;

public class PaiementMapper {

    public static PaiementDTO toPaiementDTO(Paiement  paiement){
        if(paiement==null) return null;

        PaiementDTO paiementDTO = new PaiementDTO();
        paiementDTO.setId(paiement.getId());
        paiementDTO.setCreditCardNumber(paiement.getCreditCardNumber());
        paiementDTO.setExpirationDate(paiement.getExpirationDate());
        paiementDTO.setCryptogram(paiement.getCryptogram());
        UserMapper.userDTO(paiement.getUser());
        return paiementDTO;
    }

    public static Paiement toPaiement(PaiementDTO paiementDTO){
        if(paiementDTO==null) return null;

        Paiement paiement = new Paiement();
        paiement.setId(paiementDTO.getId());
        paiement.setCreditCardNumber(paiementDTO.getCreditCardNumber());
        paiement.setExpirationDate(paiementDTO.getExpirationDate());
        paiement.setCryptogram(paiementDTO.getCryptogram());
        UserMapper.userDTO(paiement.getUser());

        return paiement;
    }
}
