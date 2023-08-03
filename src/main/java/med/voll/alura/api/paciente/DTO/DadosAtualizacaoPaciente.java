package med.voll.alura.api.paciente.DTO;

import jakarta.validation.constraints.NotNull;
import med.voll.alura.api.endereco.DadosEndereco;
import med.voll.alura.api.endereco.Endereco;

public record DadosAtualizacaoPaciente(
    @NotNull
    Long id,
    String nome,
    String telefone,
    DadosEndereco endereco
    ) {
}
