package br.tec.didiproject.queueserviceapi.repositories;

import br.tec.didiproject.queueserviceapi.entities.Departamento;
import br.tec.didiproject.queueserviceapi.entities.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface DepartamentoRepository extends JpaRepository<Departamento, UUID> {

    Set<Departamento> findAllByEmpresaId(UUID empresaId);

    Page<Departamento> findAll(Pageable pageable);

}