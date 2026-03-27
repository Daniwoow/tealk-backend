package br.com.tealk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String conteudoTexto;

    private LocalDateTime dataEnvio;

    private Boolean foiLido;

    @ManyToOne
    @JoinColumn(name = "usuario_remetent_Id")
    private Usuario usuarioRemetente;

    @ManyToOne
    @JoinColumn(name = "usuario_destinario_id")
    private Usuario usuarioDestinatario;
}
