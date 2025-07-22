package br.com.tech4me.tech4restaurante.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    private ItemCardapioService service;

    @GetMapping
    public ResponseEntity<List<ItemCardapioCompletoDTO>> obterTodos() {
    List<ItemCardapioCompletoDTO> items = service.obterTodos();
    return ResponseEntity.ok(items); 
    }




    @GetMapping("/{id}")
    public ResponseEntity<ItemCardapioCompletoDTO> obterPorId(@PathVariable String id) {
        ItemCardapioCompletoDTO item = service.obterPorId(id);

        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<List<ItemCardapioCompletoDTO>> cadastrar(@RequestBody @Valid ItemCardapioCompletoDTO item) {
        return new ResponseEntity<List<ItemCardapioCompletoDTO>>(service.obterTodos(), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCardapioCompletoDTO> atualizar(@PathVariable String id, @RequestBody @Valid ItemCardapioCompletoDTO item) {
        ItemCardapioCompletoDTO atualizado = service.atualizar(id, item);

        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable String id) {
        service.remover(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
