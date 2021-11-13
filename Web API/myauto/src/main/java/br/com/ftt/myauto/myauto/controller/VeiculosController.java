package br.com.ftt.myauto.myauto.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ftt.myauto.myauto.modelo.Veiculo;

@RestController
public class VeiculosController {
	
	@RequestMapping("/veiculos")
	public List<Veiculo> lista() {
		Veiculo veiculo = new Veiculo();
		veiculo.setMarca("Fiat");
		veiculo.setModelo("Une");
		
		return Arrays.asList(veiculo, veiculo);
	}

}
