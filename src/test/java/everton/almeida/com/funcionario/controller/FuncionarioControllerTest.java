package everton.almeida.com.funcionario.controller;

import everton.almeida.com.funcionario.model.Funcionario;
import everton.almeida.com.funcionario.service.FuncionarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FuncionarioControllerTest {

    @InjectMocks
    private FuncionarioController funcionarioController;

    @Mock
    private FuncionarioService funcionarioService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(funcionarioController).build();
    }

    @Test
    public void testCreate() {
        Funcionario funcionario = new Funcionario();
        when(funcionarioService.create(any(Funcionario.class))).thenReturn(funcionario);

        ResponseEntity<Funcionario> response = funcionarioController.create(funcionario);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(funcionario, response.getBody());
        verify(funcionarioService, times(1)).create(any(Funcionario.class));
    }

    @Test
    public void testDelete() {
        doNothing().when(funcionarioService).delete(anyLong());

        ResponseEntity<Void> response = funcionarioController.delete(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(funcionarioService, times(1)).delete(anyLong());
    }

    @Test
    public void testGetId() {
        Funcionario funcionario = new Funcionario();
        when(funcionarioService.getID(anyLong())).thenReturn(funcionario);

        ResponseEntity<Funcionario> response = funcionarioController.getId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(funcionario, response.getBody());
        verify(funcionarioService, times(1)).getID(anyLong());
    }

    @Test
    public void testGetAll() {
        List<Funcionario> funcionarios = Arrays.asList(new Funcionario(), new Funcionario());
        when(funcionarioService.getAll()).thenReturn(funcionarios);

        ResponseEntity<List<Funcionario>> response = funcionarioController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(funcionarios, response.getBody());
        verify(funcionarioService, times(1)).getAll();
    }

    @Test
    public void testUpdate() {
        Funcionario funcionario = new Funcionario();
        when(funcionarioService.update(any(Funcionario.class))).thenReturn(funcionario);

        ResponseEntity<Funcionario> response = funcionarioController.update(1L, funcionario);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(funcionario, response.getBody());
        verify(funcionarioService, times(1)).update(any(Funcionario.class));
    }
}