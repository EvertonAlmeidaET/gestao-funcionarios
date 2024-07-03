package everton.almeida.com.funcionario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {

    @Test
    public void testFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(1L);
        funcionario.setNome("João");
        funcionario.setDesignacao("Desenvolvedor");
        funcionario.setSalario(5000.0);
        funcionario.setTelefone("123456789");
        funcionario.setEndereco("Rua A, 123");

        assertEquals(1L, funcionario.getIdFuncionario());
        assertEquals("João", funcionario.getNome());
        assertEquals("Desenvolvedor", funcionario.getDesignacao());
        assertEquals(5000.0, funcionario.getSalario());
        assertEquals("123456789", funcionario.getTelefone());
        assertEquals("Rua A, 123", funcionario.getEndereco());
    }
}