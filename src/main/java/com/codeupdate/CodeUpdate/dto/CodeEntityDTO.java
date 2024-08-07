package com.codeupdate.CodeUpdate.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CodeEntityDTO {

    private String cName;
    private Double version;

    public CodeEntityDTO(String cName, Double version) {
        this.cName = cName;
        this.version = version;
    }

}

