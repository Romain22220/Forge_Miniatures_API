package com.forge_miniatures.entity;

import java.util.List;

public class Article {
    private Long id;
    private String nom;
    private String description;
    private List<Article_Image> images;
    private double prix;
    private int quantite;
    private Type type;
    private Scale scale;
    private Reference reference;

}
