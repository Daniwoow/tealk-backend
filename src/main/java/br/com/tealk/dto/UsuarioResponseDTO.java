package br.com.tealk.dto;

import br.com.tealk.model.Usuario;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String biografia;
    private String preferenciaComunicacao;
    private List<InteresseResponseDTO> interesses;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.biografia = usuario.getBiografia();

        if (usuario.getPreferenciaComunicacao() != null) {
            this.preferenciaComunicacao = usuario.getPreferenciaComunicacao().name();
        }

        if (usuario.getInteresses() != null) {
            this.interesses = usuario.getInteresses().stream()
                    .map(InteresseResponseDTO::new)
                    .collect(Collectors.toList());
        }
    }
}