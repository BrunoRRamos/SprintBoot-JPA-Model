package med.voll.alura.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.alura.api.endereco.Endereco;
import med.voll.alura.api.paciente.DTO.DadosAtualizacaoPaciente;
import med.voll.alura.api.paciente.DTO.DadosCadastroPaciente;

@Table(name = "pacientes")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Paciente(DadosCadastroPaciente data) {
        this.ativo = true;
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.cpf = data.cpf();
        this.endereco = new Endereco(data.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente data) {
        if (data.nome() != null) {
            this.nome = data.nome();
        }

        if (data.telefone() != null) {
            this.telefone = data.telefone();
        }

        if (data.endereco() != null) {
            this.endereco.atualizarInformacoes(data.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    public void reativar() {
        this.ativo = true;
    }
}
