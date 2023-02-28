package br.tec.didiproject.queueserviceapi.repositories;

import br.tec.didiproject.queueserviceapi.entities.Atendente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface AtendenteRepository extends JpaRepository<Atendente, UUID> {

    Page<Atendente> findAllByDepartamentosIdContains(UUID departamentoId, Pageable pageable);

    Page<Atendente> findAll(Pageable pageable);

}