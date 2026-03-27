package br.com.tealk.dto;

import br.com.tealk.model.Interesse;
import lombok.Data;

@Data
public class InteresseResponseDTO {
    private Long id;
    private String nomeInteresse;

    public InteresseResponseDTO(Interesse interesse) {
        this.id = interesse.getId();
        this.nomeInteresse = interesse.getNomeInteresse();
    }
}