package br.com.ftt.myauto.myauto.modelo;

import java.util.List;

public class Usuario {
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
//	private List<Veiculo> veiculos;

//	public List<Veiculo> getVeiculos() {
//		return veiculos;
//	}
//
//	public void setVeiculos(List<Veiculo> veiculos) {
//		this.veiculos = veiculos;
//	}

	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
