package br.com.tech4me.tech4pedido.controller;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4pedido.service.PedidoService;
import br.com.tech4me.tech4pedido.shared.PedidoCompletoDTO;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService servico;

   
    @GetMapping("/{id}")
    public ResponseEntity<PedidoCompletoDTO> obterPorId(@PathVariable String id) {
        PedidoCompletoDTO pedido = servico.ObterPorId(id);

        if (pedido != null) {
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PedidoCompletoDTO> cadastrar(@RequestBody PedidoCompletoDTO pedido) {
        return new ResponseEntity<>(servico.Cadastrar(pedido), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoCompletoDTO> atualizar(@PathVariable String id, @RequestBody PedidoCompletoDTO pedido) {
        PedidoCompletoDTO pedidoAtualizado = servico.Atualizar(id, pedido);

        if (pedidoAtualizado != null) {
            return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable String id) {
        servico.Remover(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
