package med.voll.alura.api.paciente.DTO;

import med.voll.alura.api.medico.DTO.DadosListagemMedico;
import med.voll.alura.api.paciente.Paciente;

public record DadosListagemPaciente(
        Long id,
        String nome,
        String email,
        String cpf
    ) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(),paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
