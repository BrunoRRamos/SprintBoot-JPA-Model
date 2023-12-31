package med.voll.alura.api.controller;

import jakarta.validation.Valid;
import med.voll.alura.api.paciente.DTO.DadosAtualizacaoPaciente;
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

    @PutMapping
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid DadosAtualizacaoPaciente data) {
        var paciente = repository.getReferenceById(data.id());
        paciente.atualizarInformacoes(data);
        return new ResponseEntity<>("Paciente atualizado", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
        return new ResponseEntity<>("Paciente excluido", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/reativar/{id}")
    @Transactional
    public ResponseEntity<?> reativar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.reativar();
        return new ResponseEntity<>("Paciente reativado", HttpStatus.OK);
    }
}
