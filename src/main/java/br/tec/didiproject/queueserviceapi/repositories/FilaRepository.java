package br.tec.didiproject.queueserviceapi.repositories;

import br.tec.didiproject.queueserviceapi.entities.Fila;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FilaRepository extends JpaRepository<Fila, UUID> {

    Page<Fila> findAllByTiposAtendimentoId(UUID tipoAtendimentoId, Pageable pageable);

    Page<Fila> findAllByDepartamentoId(UUID departamentoId, Pageable pageRequest);

    Page<Fila> findAll(Pageable pageable);
}