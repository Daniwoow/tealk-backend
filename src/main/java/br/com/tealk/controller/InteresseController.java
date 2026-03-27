package br.com.tealk.controller;

import br.com.tealk.dto.InteresseResponseDTO;
import br.com.tealk.model.Interesse;
import br.com.tealk.service.InteresseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/interesses")
@RequiredArgsConstructor
public class InteresseController {

    private final InteresseService interesseService;

    @PostMapping
    public ResponseEntity<InteresseResponseDTO> salvarInteresse(@RequestBody Interesse interesse){
        Interesse interesseUser = interesseService.salvarInteresse(interesse);
        return ResponseEntity.status(HttpStatus.CREATED).body(new InteresseResponseDTO(interesseUser));
    }

    @GetMapping
    public ResponseEntity<List<InteresseResponseDTO>> listarInteresse(){
        List<Interesse> listarInteresses =  interesseService.buscarInteresses();

        List<InteresseResponseDTO> dtosIteresses = listarInteresses
                .stream()
                .map(InteresseResponseDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtosIteresses);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarInteresse(@PathVariable Long id){
        interesseService.deletarInteresse(id);

        return ResponseEntity.noContent().build();
    }
}
