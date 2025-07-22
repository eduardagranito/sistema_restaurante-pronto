package br.com.tech4me.tech4pedido.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.tech4pedido.shared.PedidoCompletoDTO;

@Document("pedidos")
public class Pedido {
    @Id
    private String id;
    private String nomeCliente;
    private List<String> itens;
    private double valorTotal;
    private LocalDateTime data;

    public Pedido() {}

    public Pedido(PedidoCompletoDTO dto) {
        setId(dto.id());
        setNomeCliente(dto.nomeCliente());
        setItens(dto.itens());
        setValorTotal(dto.valorTotal());
        setData(dto.data());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
