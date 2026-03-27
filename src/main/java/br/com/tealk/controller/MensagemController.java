package br.com.tealk.controller;

import br.com.tealk.dto.MensagemResponseDTO;
import br.com.tealk.model.Mensagem;
import br.com.tealk.service.MensagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mensagens")
@RequiredArgsConstructor
public class MensagemController {

    private final MensagemService mensagemService;

    @PostMapping
    public ResponseEntity<MensagemResponseDTO> salvarMensagem(@RequestBody Mensagem mensagem){
        Mensagem msgSalva = mensagemService.salvarMensagem(mensagem);

        return ResponseEntity.status(HttpStatus.CREATED).body(new MensagemResponseDTO(msgSalva));
    }

    @GetMapping
    public ResponseEntity<List<MensagemResponseDTO>> listarMensagem(){
        List<Mensagem> listarMensagens = mensagemService.buscarMensagens();

        List<MensagemResponseDTO> dtos = listarMensagens
                .stream()
                .map(MensagemResponseDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarMensagem(@PathVariable Long id){
        mensagemService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
