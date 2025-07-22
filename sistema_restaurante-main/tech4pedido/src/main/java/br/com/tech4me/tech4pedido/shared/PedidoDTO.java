package br.com.tech4me.tech4pedido.shared;

import java.util.List;

public record PedidoDTO(
    String nomeCliente,
    List<String> itens
) {}
