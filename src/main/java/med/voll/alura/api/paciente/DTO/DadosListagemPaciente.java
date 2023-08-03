package med.voll.alura.api.paciente.DTO;

import med.voll.alura.api.medico.DTO.DadosListagemMedico;
import med.voll.alura.api.paciente.Paciente;

public record DadosListagemPaciente(
        String nome,
        String email,
        String cpf
    ) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
