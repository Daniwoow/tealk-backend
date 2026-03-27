package br.com.tealk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conexao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusConexao status;

    @ManyToOne
    @JoinColumn(name = "id_usuarioSolicitante")
    private Usuario usuarioSolicitante;

    @ManyToOne
    @JoinColumn(name = "id_usuarioRecebedor")
    private Usuario usuarioRecebedor;
}
