package med.voll.alura.api.controller;

import jakarta.validation.Valid;
import med.voll.alura.api.medico.DadosListagemMedico;
import med.voll.alura.api.medico.DadosCadastradosMedico;
import med.voll.alura.api.medico.Medico;
import med.voll.alura.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<DadosListagemMedico> listar() {
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }

}
