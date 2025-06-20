package com.forge_miniatures.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ContainId {

    private Integer idtPanier;
    private Integer idtArticle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof ContainId that)) return false;
        return Objects.equals(idtPanier,that.idtPanier)&&Objects.equals(idtArticle,that.idtArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtPanier, idtArticle);
    }
}
