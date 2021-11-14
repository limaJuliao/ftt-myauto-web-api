package br.com.ftt.myauto.myauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ftt.myauto.myauto.DAO.VeiculoDAO;
import br.com.ftt.myauto.myauto.modelo.Veiculo;
import br.com.ftt.myauto.myauto.repository.VeiculoRepository;

@RestController
public class VeiculosController {

	private VeiculoDAO veiculoDAO;
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@RequestMapping("/veiculos")
	public List<Veiculo> lista(int usuario) {
		return veiculoRepository.findByUsuario(usuario);
	}

}
