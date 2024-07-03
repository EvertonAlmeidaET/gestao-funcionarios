package everton.almeida.com.funcionario.controller;

import everton.almeida.com.funcionario.model.Funcionario;
import everton.almeida.com.funcionario.service.FuncionarioService;
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

    @PostMapping
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(funcionario));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getID(id));
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody Funcionario funcionario){
        funcionario.setIdFuncionario(id);
        return ResponseEntity.ok().body(service.update(funcionario));
    }
}
