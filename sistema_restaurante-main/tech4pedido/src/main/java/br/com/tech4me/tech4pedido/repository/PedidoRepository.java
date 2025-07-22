package br.com.tech4me.tech4pedido.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.tech4me.tech4pedido.model.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
}
