package br.com.ftt.myauto.myauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ftt.myauto.myauto.infra.repository.UsuarioRepository;
import br.com.ftt.myauto.myauto.modelo.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping("/login")
	public boolean login(Usuario login) {
		Usuario usuario = repository.findByEmail(login.getEmail());
		System.out.println(login.getSenha().equals(usuario.getSenha()));
		return login.getSenha() == usuario.getSenha();
	}
	
	@PostMapping("/add")
	public void cadastrar(Usuario usuario) {
		System.out.println(usuario.toString());
		repository.save(usuario);
	}
}
