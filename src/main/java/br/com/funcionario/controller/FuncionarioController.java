package br.com.funcionario.controller;

import br.com.funcionario.service.FuncionarioService;
import br.com.funcionario.model.Funcionario;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @Operation(summary = "Criar", description = "Método para criar funcionario", tags = "Funcionarios")
    @PostMapping
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(funcionario));
    }

    @Operation(summary = "Deletar por ID", description = "Método para deletar um funcionário pelo seu ID", tags = "Funcionarios")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar por ID", description = "Método para buscar um funcionário pelo seu ID", tags = "Funcionarios")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getID(id));
    }

    @Operation(summary = "Listar", description = "Método para listar todos os funcionários", tags = "Funcionarios")
    @GetMapping
    public ResponseEntity<List<Funcionario>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Atualizar por ID", description = "Método para atualizar um funcionário pelo seu ID", tags = "Funcionarios")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody Funcionario funcionario){
        funcionario.setIdFuncionario(id);
        return ResponseEntity.ok().body(service.update(funcionario));
    }
}
