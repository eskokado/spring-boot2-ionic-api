package br.com.eskinfotechweb.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eskinfotechweb.cursomc.domain.Estado;
import br.com.eskinfotechweb.cursomc.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;

 	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}
}
