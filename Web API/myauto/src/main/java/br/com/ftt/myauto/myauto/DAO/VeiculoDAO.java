package br.com.ftt.myauto.myauto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ftt.myauto.myauto.modelo.Veiculo;

public class VeiculoDAO {
	private Connection connection;

	public VeiculoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Veiculo> listar() {
		try {
			List<Veiculo> veiculos = new ArrayList<Veiculo>();
			String sql = "select * from Veiculo";
			
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while(rst.next()) {
						Veiculo veiculo = new Veiculo(rst.getString(2), rst.getString(3));						
						veiculo.setId(rst.getLong(1));
						
						veiculos.add(veiculo);
					}
				}
			}
			return veiculos;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvar(Veiculo veiculo) {
		try {
			String sql = "INSERT INTO VEICULO (MARCA, MODELO) VALUES (?, ?)";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1, veiculo.getMarca());
				pstm.setString(1, veiculo.getModelo());
				
				pstm.execute();
				
				try(ResultSet rst = pstm.getGeneratedKeys()) {
					while(rst.next()) {
						veiculo.setId(rst.getLong(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
