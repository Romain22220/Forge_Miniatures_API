package com.forge_miniatures.entity;

import java.util.Date;

public class Paiement {
    private Long id;
    private String creditCardNumber;
    private Date expirationDate;
    private String cryptogram;
    private User user;
}
