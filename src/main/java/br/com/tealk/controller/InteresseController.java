package br.com.tealk.controller;

import br.com.tealk.model.Interesse;
import br.com.tealk.service.InteresseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interesses")
@RequiredArgsConstructor
public class InteresseController {

    private final InteresseService interesseService;

    @PostMapping
    public Interesse salvarInteresse(@RequestBody Interesse interesse){
        return interesseService.salvarInteresse(interesse);
    }

    @GetMapping
    public List<Interesse> listarInteresse(){
        return interesseService.buscarInteresses();
    }

    @DeleteMapping("{id}")
    public void deletarInteresse(@PathVariable Long id){
        interesseService.deletarInteresse(id);
    }
}
