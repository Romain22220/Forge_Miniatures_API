package com.forge_miniatures.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleImageDTO {
    private Long id;
    private String imageURL;
    private Long articleId;
    private String articleName;
}
