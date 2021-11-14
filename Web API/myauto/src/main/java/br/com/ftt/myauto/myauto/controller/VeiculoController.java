package br.com.ftt.myauto.myauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ftt.myauto.myauto.infra.repository.VeiculoRepository;
import br.com.ftt.myauto.myauto.modelo.Veiculo;

@RestController
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository repository;
	
	@RequestMapping("/veiculos")
	public List<Veiculo> lista() {
		return repository.findAll();
	}

}
