package br.com.tealk.service;

import br.com.tealk.model.Conexao;
import br.com.tealk.repository.ConexaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConexaoService {

    private final ConexaoRepository conexaoRepository;

    public Conexao salvarConexao(Conexao conexao){
        return conexaoRepository.save(conexao);

    }

    public List<Conexao> buscarConexao(){
        return conexaoRepository.findAll();
    }

    public void deletarPorId(Long id){
        conexaoRepository.deleteById(id);
    }
}
