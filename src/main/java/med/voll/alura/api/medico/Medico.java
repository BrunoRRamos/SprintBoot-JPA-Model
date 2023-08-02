package med.voll.alura.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.alura.api.endereco.Endereco;
import med.voll.alura.api.medico.DTO.DadosAtualizacaoMedico;
import med.voll.alura.api.medico.DTO.DadosCadastradosMedico;
import med.voll.alura.api.medico.DTO.Especialidade;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Medico(DadosCadastradosMedico data) {
        this.ativo = true;
        this.nome = data.nome();
        this.email = data.email();
        this.crm = data.crm();
        this.telefone = data.telefone();
        this.especialidade = data.especialidade();
        this.endereco = new Endereco(data.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico data) {
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
}
