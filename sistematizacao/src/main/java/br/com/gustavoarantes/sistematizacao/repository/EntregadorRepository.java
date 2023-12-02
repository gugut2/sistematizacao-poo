package br.com.gustavoarantes.sistematizacao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavoarantes.sistematizacao.model.Entregador;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, UUID> {
    Entregador findByCpf(String cpf);
}
