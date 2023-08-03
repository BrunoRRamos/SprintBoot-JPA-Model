package med.voll.alura.api.controller;

import jakarta.validation.Valid;
import med.voll.alura.api.paciente.DTO.DadosCadastroPaciente;
import med.voll.alura.api.paciente.DTO.DadosListagemPaciente;
import med.voll.alura.api.paciente.Paciente;
import med.voll.alura.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroPaciente data) {
        repository.save(new Paciente(data));
        return new ResponseEntity<>("Paciente criado com Sucesso", HttpStatus.CREATED);
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @GetMapping("/{id}")
    public DadosListagemPaciente listarById(@PathVariable Long id) {
        return repository.findOneByIdAndAtivoTrue(id);
    }
}
