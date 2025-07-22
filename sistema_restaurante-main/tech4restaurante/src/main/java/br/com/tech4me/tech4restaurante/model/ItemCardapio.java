package br.com.tech4me.tech4restaurante.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.tech4restaurante.controller.ItemCardapioCompletoDTO;


@Document("cardapio")
public class ItemCardapio {
    @Id
    private String id;
    private String nome;
    private List<String> ingredientes;
    private String categoria;
    private double preco;

    public ItemCardapio() {}

    public ItemCardapio(ItemCardapioCompletoDTO dto) {
        this.id = dto.id();
        this.nome = dto.nome();
        this.ingredientes = dto.ingredientes();
        this.categoria = dto.categoria();
        this.preco = dto.preco();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<String> getIngredientes() { return ingredientes; }
    public void setIngredientes(List<String> ingredientes) { this.ingredientes = ingredientes; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public List<String> getSabor() {
        throw new UnsupportedOperationException("Unimplemented method 'getSabor'");
    }

    public Object getTamanho() {
        throw new UnsupportedOperationException("Unimplemented method 'getTamanho'");
    }

    public Object getValor() {
        throw new UnsupportedOperationException("Unimplemented method 'getValor'");
    }
}
