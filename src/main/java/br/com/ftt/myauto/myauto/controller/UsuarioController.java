package br.com.ftt.myauto.myauto.controller;

import java.sql.Connection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ftt.myauto.myauto.ConnectionFactory;
import br.com.ftt.myauto.myauto.infra.DAO.UsuarioDAO;
import br.com.ftt.myauto.myauto.modelo.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	private Connection connection = new ConnectionFactory().recuperarConexao();		
	private UsuarioDAO dao = new UsuarioDAO(connection);
	
	@PostMapping("/login")
	public Usuario login(Usuario login) {
		
		Usuario usuario = dao.obterUsuarioPorEmail(login.getEmail());
		System.out.println(login.getSenha().equals(usuario.getSenha()));
		return usuario;
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(Usuario usuario) {
		dao.salvar(usuario);
	}
}
