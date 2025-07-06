package com.forge_miniatures.dto;

import com.forge_miniatures.entity.ArticleImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    private Long id;
    private String name;
    private String marque;
    private String description;
    private List<String> images;
    private double price;
    private int quantite;
    private Date dateCreation;
    private Date datePublication;
    private Long typeId;
    private String typeName;
    private Long statusId;
    private String statutName;
    private Long scaleId;
    private String scaleName;
    private Long referenceId;
    private String referenceName;
}
