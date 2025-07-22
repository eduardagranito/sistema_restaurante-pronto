package br.com.tech4me.tech4restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.tech4restaurante.model.ItemCardapio;
import br.com.tech4me.tech4restaurante.repository.ItemCardapioRepository;
import br.com.tech4me.tech4restaurante.shared.ItemCardapioDTO;


@Service
public class CardapioServiceImpl implements CardapioService {

    @Autowired
    private ItemCardapioRepository repository;

    @Override
    public List<ItemCardapioDTO> ObterTodos() {
        return repository.findAll()
            .stream()
            .map(p -> new ItemCardapioDTO(p.getSabor(), p.getIngredientes()))
            .toList();
    }

    @Override
    public ItemCardapioDTO ObterPorId(String id) {
        ItemCardapio restaurante = repository.findById(id).orElse(null);

        if (restaurante != null) {
            return new ItemCardapioDTO(restaurante.getSabor(),
                restaurante.getIngredientes());
        } else {
            return null;
        }
    }

    @Override
    public ItemCardapioDTO Cadastrar(ItemCardapioDTO restaurante) {
        ItemCardapio restauranteCadastro = new ItemCardapio();
        repository.save(restauranteCadastro);

        return new ItemCardapioDTO(restauranteCadastro.getSabor(),
            restauranteCadastro.getIngredientes());
    }

    @Override
    public ItemCardapioDTO Atualizar(String id, ItemCardapioDTO restaurante) {
        ItemCardapio restauranteLocalizada = repository.findById(id).orElse(null);

        if (restauranteLocalizada != null) {
            

            ItemCardapio restauranteAtualizacao = new ItemCardapio();
            restauranteAtualizacao.setId(id);
            repository.save(restauranteAtualizacao);

            return new ItemCardapioDTO(restauranteAtualizacao.getSabor(),
                restauranteAtualizacao.getIngredientes());
        } else {
            return null;
        }
    }

    @Override
    public void Remover(String id) {
        repository.deleteById(id);
    }

}
