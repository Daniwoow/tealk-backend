package br.com.tealk.service;

import br.com.tealk.model.Mensagem;
import br.com.tealk.repository.MensagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MensagemService {

    private final MensagemRepository mensagemRepository;

    //salvar, listar, deletar por id

    public Mensagem salvarMensagem(Mensagem mensagem){
        return mensagemRepository.save(mensagem);
    }

    public List<Mensagem> buscarMensagens(){
        return mensagemRepository.findAll();
    }

    public void deletarPorId(Long id){
        mensagemRepository.deleteById(id);
    }



}
