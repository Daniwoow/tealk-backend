package br.com.tealk.dto;

import br.com.tealk.model.Mensagem;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MensagemResponseDTO {
    private Long id;
    private String conteudo;
    private LocalDateTime dataEnvio;
    private boolean foiLido;
    private UsuarioResponseDTO usuarioRemetente;
    private UsuarioResponseDTO usuarioDestinatario;


    public MensagemResponseDTO(Mensagem mensagem){
        this.id = mensagem.getId();
        this.conteudo = mensagem.getConteudoTexto();
        this.dataEnvio = mensagem.getDataEnvio();
        this.foiLido = mensagem.getFoiLido();
        this.usuarioRemetente = new UsuarioResponseDTO(mensagem.getUsuarioRemetente());
        this.usuarioDestinatario = new UsuarioResponseDTO(mensagem.getUsuarioDestinatario());

    }
}
