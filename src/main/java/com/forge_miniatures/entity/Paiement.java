package com.forge_miniatures.entity;

import java.util.Date;

public class Paiement {
    int id;
    String creditCardNumber;
    Date expirationDate;
    String cryptogram;
    User user;
}
