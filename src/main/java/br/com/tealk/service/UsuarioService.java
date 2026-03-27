package br.com.tealk.service;

import br.com.tealk.model.Usuario;
import br.com.tealk.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
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
