package com.forge_miniatures.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t1m_scale_scl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idt_scale")
    private Long id;

    @Column(name="scale")
    private String scale;
}
