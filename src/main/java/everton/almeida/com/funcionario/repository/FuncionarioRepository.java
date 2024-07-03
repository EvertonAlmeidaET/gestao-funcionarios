package everton.almeida.com.funcionario.repository;

import everton.almeida.com.funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
