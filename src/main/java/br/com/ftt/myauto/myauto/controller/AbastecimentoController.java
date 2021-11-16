package br.com.ftt.myauto.myauto.controller;

import java.sql.Connection;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ftt.myauto.myauto.ConnectionFactory;
import br.com.ftt.myauto.myauto.infra.DAO.AbastecimentoDAO;
import br.com.ftt.myauto.myauto.modelo.Abastecimento;
import br.com.ftt.myauto.myauto.modelo.Veiculo;

@RestController
@RequestMapping("/abastecimento")
public class AbastecimentoController {
	
	private Connection connection = new ConnectionFactory().recuperarConexao();		
	private AbastecimentoDAO dao = new AbastecimentoDAO(connection);
	
	@PostMapping("/veiculo")
	public List<Abastecimento> listarPorVeiculo(Veiculo veiculo){
		return dao.listar(veiculo.getId());
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(Abastecimento abastecimento) {
		this.dao.salvar(abastecimento);
	}
	
}
