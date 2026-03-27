package br.com.tealk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;


    @Column(nullable = false)
    private String senha;
    private String biografia;

    @Enumerated(EnumType.STRING)
    @Column(name = "preferencia_comunicacao")
    private PreferenciaComunicacao preferenciaComunicacao;


    @ManyToMany
    @JoinTable(
            name = "usuario_interesse",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name =  "interesse_id")
    )
    private List<Interesse> interesses = new ArrayList<>();

    //varias conexoes enviadas
    @OneToMany(mappedBy = "usuarioSolicitante")
    private List<Conexao> conexoesEnviadas = new ArrayList<>();

    //varias conexoes recebidas
    @OneToMany(mappedBy = "usuarioRecebedor")
    private List<Conexao> conexoesRecebidas = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioRemetente")
    private List<Mensagem> mensagensEnviadas = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioDestinatario")
    private List<Mensagem> mensagensRecebidas = new ArrayList<>();
}
