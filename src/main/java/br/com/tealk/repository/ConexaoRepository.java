package br.com.tealk.repository;

import br.com.tealk.model.Conexao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConexaoRepository extends JpaRepository<Conexao, Long> {
}
