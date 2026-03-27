package br.com.tealk.controller;

import br.com.tealk.dto.ConexaoResponseDTO;
import br.com.tealk.model.Conexao;
import br.com.tealk.model.Interesse;
import br.com.tealk.service.ConexaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conexoes")
@RequiredArgsConstructor
public class ConexaoController {

    private final ConexaoService conexaoService;

    @PostMapping
    public ResponseEntity<ConexaoResponseDTO> salvarConexao(@RequestBody Conexao conexao){
       Conexao conexaoSalva = conexaoService.salvarConexao(conexao);

       return ResponseEntity.status(HttpStatus.CREATED).body(new ConexaoResponseDTO(conexaoSalva));
    }

    @GetMapping
    public ResponseEntity<List<ConexaoResponseDTO>> listarConexao(){
        List<Conexao> listagemConexao = conexaoService.buscarConexao();

        List<ConexaoResponseDTO> dtosConexoes = listagemConexao
                .stream()
                .map(ConexaoResponseDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtosConexoes);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarConexao(@PathVariable Long id){
        conexaoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
