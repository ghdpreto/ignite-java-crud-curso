package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ghdpreto.ignite_java_crud_curso.entities.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, UUID> {

}
