package br.com.tech4me.tech4pedido.shared;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoCompletoDTO(
    String id,
    String nomeCliente,
    List<String> itens,
    double valorTotal,
    LocalDateTime data
) {}

