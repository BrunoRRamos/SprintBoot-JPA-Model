package med.voll.alura.api.controller;

import jakarta.validation.Valid;
import med.voll.alura.api.medico.DTO.DadosAtualizacaoMedico;
import med.voll.alura.api.medico.DTO.DadosListagemMedico;
import med.voll.alura.api.medico.DTO.DadosCadastradosMedico;
import med.voll.alura.api.medico.Medico;
import med.voll.alura.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastradosMedico data) {
        repository.save(new Medico(data));
        return new ResponseEntity<>("Médico Cadastrado com Sucesso", HttpStatus.CREATED);
    }

    //Pelo params da requisição pode ser escolhido a quantidade de registros a
    //serem retornados "medicos?size=(numero de registros)" o default é 20.
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @GetMapping("/{id}")
    public DadosListagemMedico listarById(@PathVariable Long id) {
        return repository.findOneByIdAndAtivoTrue(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid DadosAtualizacaoMedico data) {
        var medico = repository.getReferenceById(data.id());
        medico.atualizarInformacoes(data);
        return new ResponseEntity<>("Médico atualizado", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return new ResponseEntity<>("Médico excluido com Sucesso", HttpStatus.NO_CONTENT);
    }


}
