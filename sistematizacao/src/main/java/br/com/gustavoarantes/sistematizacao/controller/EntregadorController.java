package br.com.gustavoarantes.sistematizacao.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoarantes.sistematizacao.model.Entregador;
import br.com.gustavoarantes.sistematizacao.repository.EntregadorRepository;
import br.com.gustavoarantes.sistematizacao.utils.Utils;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @GetMapping
    public ResponseEntity<List<Entregador>> listar() {
        List<Entregador> entregadorList = entregadorRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(entregadorList);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> adicionar(@RequestBody Entregador request) {
        //var entregador = this.entregadorRepository.
        Entregador entregador = this.entregadorRepository.findByCpf(request.getCpf());

        if(entregador == null) {
            entregadorRepository.save(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário " + request.getNome() + " cadastrado");
        } 
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um Entregador com este CPF");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> detalhar(@PathVariable(value="id") UUID id){
        Optional<Entregador> entregador = entregadorRepository.findById(id);
        if(entregador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entregador.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarEntregador(@RequestBody Entregador entregadorModel, @PathVariable(value="id") UUID id){
        var entregador = this.entregadorRepository.findById(id).orElse(null);

        if(entregador == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado");
        }

        Utils.copyNonNullProperties(entregadorModel, entregador);

        return ResponseEntity.status(HttpStatus.OK).body(this.entregadorRepository.save(entregador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarEntregador(@PathVariable(value="id") UUID id){
        Optional<Entregador> entregador = entregadorRepository.findById(id);

        if(entregador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado");
        }

        entregadorRepository.delete(entregador.get());
        return ResponseEntity.status(HttpStatus.OK).body("O entregador foi excluído");
    }
}
