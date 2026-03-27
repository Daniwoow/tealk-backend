package br.com.tealk.controller;

import br.com.tealk.model.Conexao;
import br.com.tealk.model.Interesse;
import br.com.tealk.service.ConexaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conexoes")
@RequiredArgsConstructor
public class ConexaoController {

    private final ConexaoService conexaoService;

    @PostMapping
    public Conexao salvarConexao(@RequestBody Conexao conexao){
       return conexaoService.salvarConexao(conexao);
    }

    @GetMapping
    public List<Conexao> listarConexao(){
        return conexaoService.buscarConexao();
    }

    @DeleteMapping("{id}")
    public void deletarCoenexao(@PathVariable Long id){
        conexaoService.deletarPorId(id);
    }
}
