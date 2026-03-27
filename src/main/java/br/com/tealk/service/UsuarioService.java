package br.com.tealk.service;

import br.com.tealk.model.Interesse;
import br.com.tealk.model.Usuario;
import br.com.tealk.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final InteresseService interesseService; // adiciona aqui
    public Usuario salvarUsuario(Usuario usuario){

        //Verifica se veio algum interesse no JSON
        if(usuario.getInteresses() != null){
            //Para cada interesse que veio só com id
            List<Interesse> interesses = usuario.getInteresses()
                    .stream()
                    .map(i -> interesseService.buscarPorId(i.getId())) //busca cada um no banco pelo id
                    .collect(Collectors.toList());

            //ubstitui a lista incompleta pela lista completa do banco
        usuario.setInteresses(interesses);
        }

        //salva o user com interesses
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();

    }

    public Optional<Usuario> buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public void deletarPorId(Long id){
        usuarioRepository.deleteById(id);
    }
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado){
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setBiografia(usuarioAtualizado.getBiografia());
        usuarioExistente.setPreferenciaComunicacao(usuarioAtualizado.getPreferenciaComunicacao());
        usuarioExistente.setInteresses(usuarioAtualizado.getInteresses());

        return usuarioRepository.save(usuarioExistente);
    }

}
