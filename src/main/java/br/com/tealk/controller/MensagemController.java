package br.com.tealk.controller;

import br.com.tealk.model.Mensagem;
import br.com.tealk.service.MensagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagens")
@RequiredArgsConstructor
public class MensagemController {

    private final MensagemService mensagemService;

    @PostMapping
    public Mensagem salvarMensagem(@RequestBody Mensagem mensagem){
        return mensagemService.salvarMensagem(mensagem);
    }

    @GetMapping
    public List<Mensagem> listarMensagem(){
        return mensagemService.buscarMensagens();
    }

    @DeleteMapping("{id}")
    public void deletarMensagem(@PathVariable Long id){
        mensagemService.deletarPorId(id);
    }
}
