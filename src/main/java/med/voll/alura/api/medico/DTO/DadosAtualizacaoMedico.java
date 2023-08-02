package med.voll.alura.api.medico.DTO;

import jakarta.validation.constraints.NotNull;
import med.voll.alura.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
    ) {
}
