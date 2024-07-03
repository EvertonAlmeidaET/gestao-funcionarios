package everton.almeida.com.funcionario.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "idFuncionario")

@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("designacao")
    private String designacao;

    @JsonProperty("salario")
    private Double salario;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("endereco")
    private String endereco;
}
