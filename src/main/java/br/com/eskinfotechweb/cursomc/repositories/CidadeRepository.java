package br.com.eskinfotechweb.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eskinfotechweb.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
