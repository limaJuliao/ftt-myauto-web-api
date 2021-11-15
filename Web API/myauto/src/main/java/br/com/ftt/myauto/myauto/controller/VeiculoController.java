package br.com.ftt.myauto.myauto.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ftt.myauto.myauto.ConnectionFactory;
import br.com.ftt.myauto.myauto.infra.DAO.VeiculoDAO;
import br.com.ftt.myauto.myauto.modelo.Usuario;
import br.com.ftt.myauto.myauto.modelo.Veiculo;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	private Connection connection = new ConnectionFactory().recuperarConexao();		
	private VeiculoDAO dao = new VeiculoDAO(connection);
	
	@PostMapping("/usuario")
	public List<Veiculo> listarPorUsuario(Usuario usuario){
		return dao.listar(usuario.getId());
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(Veiculo veiculo) {
		this.dao.salvar(veiculo);
	}
	

}
