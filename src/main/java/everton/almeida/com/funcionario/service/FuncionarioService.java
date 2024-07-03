package everton.almeida.com.funcionario.service;

import everton.almeida.com.funcionario.model.Funcionario;
import everton.almeida.com.funcionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario create(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Funcionario getID(Long id){
        Optional<Funcionario> funcionario = repository.findById(id);
        return funcionario.get();
    }

    public List<Funcionario> getAll(){
        return repository.findAll();
    }

    public Funcionario update(Funcionario funcionario){
        Optional<Funcionario> newFuncionario = repository.findById(funcionario.getIdFuncionario());
        updateFuncionario(newFuncionario, funcionario);
        return repository.save(newFuncionario.get());
    }

    private void updateFuncionario(Optional<Funcionario> newFuncionario, Funcionario funcionario) {

        Funcionario funcionarioNovo = newFuncionario.get();
        funcionarioNovo.setNome(funcionario.getNome());
        funcionarioNovo.setEndereco(funcionario.getEndereco());
        funcionarioNovo.setDesignacao(funcionario.getDesignacao());
        funcionarioNovo.setSalario(funcionario.getSalario());
        funcionarioNovo.setTelefone(funcionario.getTelefone());

    }
}
