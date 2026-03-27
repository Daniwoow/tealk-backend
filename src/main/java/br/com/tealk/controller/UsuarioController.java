package br.com.tealk.controller;

import br.com.tealk.model.Usuario;
import br.com.tealk.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuario();
    }

    @GetMapping("/buscar-email")
    public Optional<Usuario> buscarEmail(@RequestParam String email){
        return usuarioService.buscarPorEmail(email);
    }

    @DeleteMapping("{id}")
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.atualizarUsuario(id, usuario);
    }
}
