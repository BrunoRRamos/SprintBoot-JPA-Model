package med.voll.alura.api.repository;

import med.voll.alura.api.medico.DTO.DadosListagemMedico;
import med.voll.alura.api.medico.Medico;
import med.voll.alura.api.paciente.DTO.DadosListagemPaciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
    DadosListagemMedico findOneByIdAndAtivoTrue(Long id);
}
