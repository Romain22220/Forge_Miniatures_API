package com.forge_miniatures.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="t1m_paiement_pmt")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="credit_Card")
    private String creditCardNumber;

    @Column(name="date_expiration")
    private Date expirationDate;

    @Column(name="cryptogram")
    private String cryptogram;

    @OneToOne
    @JoinColumn(name="idt_user")
    private User user;
}
