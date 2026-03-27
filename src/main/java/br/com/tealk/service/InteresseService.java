package br.com.tealk.service;

import br.com.tealk.model.Interesse;
import br.com.tealk.repository.InteresseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InteresseService {

    private final InteresseRepository interesseRepository;

    public Interesse salvarInteresse(Interesse interesse){
        return interesseRepository.save(interesse);
    }

    public List<Interesse> buscarInteresses(){
        return interesseRepository.findAll();
    }

    public void deletarInteresse(Long id){
        interesseRepository.deleteById(id);
    }
}
