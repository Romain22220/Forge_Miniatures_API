package com.forge_miniatures.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaiementDTO {
    private Long id;
    private String creditCardNumber;
    private Date expirationDate;
    private String cryptogram;
    private String user;
}
