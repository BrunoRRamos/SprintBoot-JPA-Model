package med.voll.alura.api.medico;

import med.voll.alura.api.endereco.DadosEndereco;

public record DadosCadastradosMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco dadosEndereco
    ) {
}
