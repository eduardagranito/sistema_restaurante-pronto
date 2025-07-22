package br.com.tech4me.tech4pedido.service;

import java.util.List;

import br.com.tech4me.tech4pedido.shared.PedidoCompletoDTO;
import br.com.tech4me.tech4pedido.shared.PedidoDTO;

public interface PedidoService {
    List<PedidoDTO> ObterTodos();
    PedidoCompletoDTO ObterPorId(String id);
    PedidoCompletoDTO Cadastrar(PedidoCompletoDTO pedido);
    PedidoCompletoDTO Atualizar(String id, PedidoCompletoDTO pedido);
    void Remover(String id);
    Object obterTodos();
}
