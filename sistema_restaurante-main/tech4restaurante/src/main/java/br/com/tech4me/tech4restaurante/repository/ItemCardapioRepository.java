package br.com.tech4me.tech4restaurante.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.tech4me.tech4restaurante.model.ItemCardapio;

public interface ItemCardapioRepository extends MongoRepository<ItemCardapio, String> {}

