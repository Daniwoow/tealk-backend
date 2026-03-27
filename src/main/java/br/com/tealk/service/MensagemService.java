package br.com.tealk.service;

import br.com.tealk.model.Mensagem;
import br.com.tealk.model.Usuario;
import br.com.tealk.repository.MensagemRepository;
import br.com.tealk.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MensagemService {

    private final MensagemRepository mensagemRepository;
    private final UsuarioRepository usuarioRepository;

    //salvar, listar, deletar por id

    public Mensagem salvarMensagem(Mensagem mensagem){

        Usuario remetente = usuarioRepository.findById(mensagem.getUsuarioRemetente().getId())
                .orElseThrow(() -> new RuntimeException("Remetente não encontrado"));
        Usuario destinatario = usuarioRepository.findById(mensagem.getUsuarioDestinatario().getId())
                .orElseThrow(() -> new RuntimeException("Destinatário não encontrado"));

        mensagem.setUsuarioRemetente(remetente);
        mensagem.setUsuarioDestinatario(destinatario);
        mensagem.setFoiLido(false);
        mensagem.setDataEnvio(LocalDateTime.now());

        return mensagemRepository.save(mensagem);
    }

    public List<Mensagem> buscarMensagens(){
        return mensagemRepository.findAll();
    }

    public void deletarPorId(Long id){
        mensagemRepository.deleteById(id);
    }



}
