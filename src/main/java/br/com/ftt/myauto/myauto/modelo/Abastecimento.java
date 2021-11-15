package br.com.ftt.myauto.myauto.modelo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Abastecimento {
	
	private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private String data;
	private Long odometro;
	private Double precoLitro;
	private Double volume;
	private Double precoTotal;
	private Long veiculoId;	
	
	public Abastecimento(String data, Long odometro, Double precoLitro, Double volume, Double precoTotal,
			Long veiculoId) {
		super();
		this.data = data;
		this.odometro = odometro;
		this.precoLitro = precoLitro;
		this.volume = volume;
		this.precoTotal = precoTotal;
		this.veiculoId = veiculoId;
	}
	public Long getVeiculoId() {
		return veiculoId;
	}
	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Long getOdometro() {
		return odometro;
	}
	public void setOdometro(Long odometro) {
		this.odometro = odometro;
	}
	public Double getPrecoLitro() {
		return precoLitro;
	}
	public void setPrecoLitro(Double precoLitro) {
		this.precoLitro = precoLitro;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double litro) {
		this.volume = litro;
	}
	public Double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
}
