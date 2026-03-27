package br.com.tealk.service;

import br.com.tealk.model.Conexao;
import br.com.tealk.model.Usuario;
import br.com.tealk.repository.ConexaoRepository;
import br.com.tealk.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConexaoService {

    private final ConexaoRepository conexaoRepository;
    private final UsuarioRepository usuarioRepository;

    public Conexao salvarConexao(Conexao conexao){

        Usuario solicitante = usuarioRepository.findById(conexao.getUsuarioSolicitante().getId())
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        Usuario recebedor = usuarioRepository.findById(conexao.getUsuarioRecebedor().getId())
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        conexao.setUsuarioSolicitante(solicitante);
        conexao.setUsuarioRecebedor(recebedor);

        conexao.setDataCriacao(LocalDateTime.now());

        return conexaoRepository.save(conexao);

    }

    public List<Conexao> buscarConexao(){
        return conexaoRepository.findAll();
    }

    public void deletarPorId(Long id){
        conexaoRepository.deleteById(id);
    }
}
