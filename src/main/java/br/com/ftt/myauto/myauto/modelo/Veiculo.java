package br.com.ftt.myauto.myauto.modelo;

public class Veiculo {
	
	private Long id;
	private String marca;
	private String modelo;
	private Long usuarioId;

	public Veiculo(String marca, String modelo, Long usuarioId) {
		this.marca = marca;
		this.modelo = modelo;
		this.usuarioId = usuarioId;
	}

	public Veiculo() {
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
