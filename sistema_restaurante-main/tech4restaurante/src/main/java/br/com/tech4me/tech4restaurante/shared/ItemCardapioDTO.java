package br.com.tech4me.tech4restaurante.shared;

import java.util.List;

 public record ItemCardapioDTO(List<String> sabor2, List<String> ingredientes2) {

    public ItemCardapioDTO(List<String> sabor2, List<String> ingredientes2) {
        this.sabor2 = sabor2;
        this.ingredientes2 = ingredientes2;
    }
}



