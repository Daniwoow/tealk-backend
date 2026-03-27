package br.com.tealk.dto;

import br.com.tealk.model.Conexao;
import br.com.tealk.model.StatusConexao;
import br.com.tealk.model.Usuario;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConexaoResponseDTO {

    private Long id;
    private StatusConexao status;
    private LocalDateTime dataCriacao;
    private UsuarioResponseDTO usarioSolicitante;
    private UsuarioResponseDTO usarioRecebedor;

    public ConexaoResponseDTO(Conexao conexao) {
        this.id = conexao.getId();
        this.status = conexao.getStatus();
        this.dataCriacao = conexao.getDataCriacao();
        this.usarioSolicitante = new UsuarioResponseDTO(conexao.getUsuarioSolicitante());
        this.usarioRecebedor = new UsuarioResponseDTO(conexao.getUsuarioRecebedor());
    }

}
