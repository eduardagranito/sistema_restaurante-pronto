package br.com.tech4me.tech4restaurante.service;

import java.util.List;

import br.com.tech4me.tech4restaurante.shared.ItemCardapioDTO;

public interface CardapioService {
    List<ItemCardapioDTO> ObterTodos();
    ItemCardapioDTO ObterPorId(String id);
    ItemCardapioDTO Cadastrar(ItemCardapioDTO restaurante);
    ItemCardapioDTO Atualizar(String id, ItemCardapioDTO restaurante);
    void Remover(String id);
}
