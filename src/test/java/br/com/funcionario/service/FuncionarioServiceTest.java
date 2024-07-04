package br.com.funcionario.service;

import br.com.funcionario.model.Funcionario;
import br.com.funcionario.repository.FuncionarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FuncionarioServiceTest {

    @Mock
    private FuncionarioRepository repositoryMock;

    @InjectMocks
    private FuncionarioService funcionarioService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(1L);
        funcionario.setNome("João");
        funcionario.setEndereco("Rua A, 123");
        funcionario.setDesignacao("Analista");
        funcionario.setSalario(5000.0);
        funcionario.setTelefone("99999999");

        when(repositoryMock.save(any(Funcionario.class))).thenReturn(funcionario);

        Funcionario savedFuncionario = funcionarioService.create(funcionario);

        assertEquals(funcionario.getIdFuncionario(), savedFuncionario.getIdFuncionario());
        assertEquals(funcionario.getNome(), savedFuncionario.getNome());
        assertEquals(funcionario.getEndereco(), savedFuncionario.getEndereco());
        assertEquals(funcionario.getDesignacao(), savedFuncionario.getDesignacao());
        assertEquals(funcionario.getSalario(), savedFuncionario.getSalario(), 0.001);
        assertEquals(funcionario.getTelefone(), savedFuncionario.getTelefone());

        verify(repositoryMock, times(1)).save(any(Funcionario.class));
    }

    @Test
    public void testGetFuncionarioById() {
        Long id = 1L;
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(id);
        funcionario.setNome("Maria");

        when(repositoryMock.findById(id)).thenReturn(Optional.of(funcionario));

        Funcionario retrievedFuncionario = funcionarioService.getID(id);

        assertEquals(funcionario.getIdFuncionario(), retrievedFuncionario.getIdFuncionario());
        assertEquals(funcionario.getNome(), retrievedFuncionario.getNome());

        verify(repositoryMock, times(1)).findById(id);
    }

    @Test
    public void testGetAllFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario(1L, "Carlos", "Analista de Sistemas", 9000.0, "112222-5566", "Av juvenal 654"));
        funcionarios.add(new Funcionario(2L, "Ana", "Gerente", 20000.0, "116655-3344", "Rua Santo me salva 5547"));

        when(repositoryMock.findAll()).thenReturn(funcionarios);

        List<Funcionario> retrievedFuncionarios = funcionarioService.getAll();

        assertEquals(funcionarios.size(), retrievedFuncionarios.size());
        for (int i = 0; i < funcionarios.size(); i++) {
            assertEquals(funcionarios.get(i).getIdFuncionario(), retrievedFuncionarios.get(i).getIdFuncionario());
            assertEquals(funcionarios.get(i).getNome(), retrievedFuncionarios.get(i).getNome());
            assertEquals(funcionarios.get(i).getEndereco(), retrievedFuncionarios.get(i).getEndereco());
            assertEquals(funcionarios.get(i).getDesignacao(), retrievedFuncionarios.get(i).getDesignacao());
            assertEquals(funcionarios.get(i).getSalario(), retrievedFuncionarios.get(i).getSalario(), 0.001);
            assertEquals(funcionarios.get(i).getTelefone(), retrievedFuncionarios.get(i).getTelefone());
        }

        verify(repositoryMock, times(1)).findAll();
    }

    @Test
    public void testUpdateFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(1L);
        funcionario.setNome("Pedro");
        funcionario.setEndereco("Rua D, 321");
        funcionario.setDesignacao("Coordenador");
        funcionario.setSalario(6000.0);
        funcionario.setTelefone("112245-6665");

        when(repositoryMock.findById(funcionario.getIdFuncionario())).thenReturn(Optional.of(funcionario));
        when(repositoryMock.save(any(Funcionario.class))).thenReturn(funcionario);

        Funcionario updatedFuncionario = funcionarioService.update(funcionario);

        assertEquals(funcionario.getIdFuncionario(), updatedFuncionario.getIdFuncionario());
        assertEquals(funcionario.getNome(), updatedFuncionario.getNome());
        assertEquals(funcionario.getEndereco(), updatedFuncionario.getEndereco());
        assertEquals(funcionario.getDesignacao(), updatedFuncionario.getDesignacao());
        assertEquals(funcionario.getSalario(), updatedFuncionario.getSalario(), 0.001);
        assertEquals(funcionario.getTelefone(), updatedFuncionario.getTelefone());

        verify(repositoryMock, times(1)).findById(funcionario.getIdFuncionario());
        verify(repositoryMock, times(1)).save(any(Funcionario.class));
    }

    @Test
    public void testDeleteFuncionario() {
        Long id = 1L;

        funcionarioService.delete(id);

        verify(repositoryMock, times(1)).deleteById(id);
    }
}

