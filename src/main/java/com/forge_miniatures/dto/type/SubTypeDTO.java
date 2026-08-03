package com.forge_miniatures.dto.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubTypeDTO {
    private Long id;
    private String name;
    private String TypeName;
    private Long typeId;
}
