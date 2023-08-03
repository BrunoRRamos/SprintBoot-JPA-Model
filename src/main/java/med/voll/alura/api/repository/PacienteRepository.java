package med.voll.alura.api.repository;

import med.voll.alura.api.paciente.DTO.DadosListagemPaciente;
import med.voll.alura.api.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);
    DadosListagemPaciente findOneByIdAndAtivoTrue(Long id);
}
