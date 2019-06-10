package br.com.eskinfotechweb.cursomc.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.eskinfotechweb.cursomc.domain.Categoria;
import br.com.eskinfotechweb.cursomc.services.CategoriaService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public List<Categoria> listar() {
		
		Categoria cat1= new Categoria(1, "Informática");
		Categoria cat2= new Categoria(2, "Escritório");
		
		List<Categoria> lista = new ArrayList<Categoria>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Categoria obj = service.find(id);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
}
