package br.com.tealk.controller;

import br.com.tealk.dto.UsuarioResponseDTO;
import br.com.tealk.model.Usuario;
import br.com.tealk.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> salvarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioResponseDTO(usuarioSalvo));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.listarUsuario();

        List<UsuarioResponseDTO> dtos =  usuarios
                .stream()
                .map(UsuarioResponseDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/buscar-email")
    public ResponseEntity<UsuarioResponseDTO> buscarEmail(@RequestParam String email){
        Optional<Usuario> usuarioEmail = usuarioService.buscarPorEmail(email);

        if(usuarioEmail.isPresent()){
            return ResponseEntity.ok(new UsuarioResponseDTO(usuarioEmail.get()));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        usuarioService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioAtualizado =  usuarioService.atualizarUsuario(id, usuario);

        return ResponseEntity.ok(new UsuarioResponseDTO(usuarioAtualizado));
    }
}
