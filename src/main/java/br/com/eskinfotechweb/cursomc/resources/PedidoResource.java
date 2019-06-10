package br.com.eskinfotechweb.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eskinfotechweb.cursomc.domain.Pedido;
import br.com.eskinfotechweb.cursomc.services.PedidoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;
	
	@GetMapping
	public List<Pedido> listar() {
		
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Pedido obj = service.find(id);
		return ResponseEntity.ok(obj);
	}
	
}
