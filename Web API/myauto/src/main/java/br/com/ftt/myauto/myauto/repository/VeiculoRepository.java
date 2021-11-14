package br.com.ftt.myauto.myauto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ftt.myauto.myauto.modelo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	List<Veiculo> findByUsuario(int usuario);

}
